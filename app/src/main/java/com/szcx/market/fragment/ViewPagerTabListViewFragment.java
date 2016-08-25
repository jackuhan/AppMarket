package com.szcx.market.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.util.LogUtils;
import com.szcx.market.MarketApplication;
import com.szcx.market.R;
import com.szcx.market.adapter.AppListAdapter;
import com.szcx.market.download.DownloadInfo;
import com.szcx.market.download.DownloadRequestCallBack;
import com.szcx.market.homeinteractive.ObservableRecyclerView;
import com.szcx.market.models.AppInfoBean;
import com.szcx.market.models.AppListBean;
import com.szcx.market.network.ApiHelper;
import com.szcx.market.network.ApiRequest;
import com.szcx.market.network.GsonGetRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerTabListViewFragment extends BaseFragment implements AppListAdapter.OnItemClickListener {
  public String TAG = "ViewPagerTabListViewFragment";
  @Bind(R.id.scroll) ObservableRecyclerView scroll;
  AppListAdapter appListAdapter;
  List<AppInfoBean> appListBeen = new ArrayList<>();

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_listview, container, false);
    ButterKnife.bind(this, view);
    initview();
    setHotApp();
    return view;
  }

  private void initview() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    scroll.setLayoutManager(layoutManager);
    scroll.setVerticalScrollBarEnabled(false);
  }

  private void setHotApp() {
    GsonGetRequest<AppListBean> gsonGetRequest =
        ApiRequest.getAppList(ApiHelper.P_RECOMMEND, ApiHelper.TYPE_APP, 1, new Response.Listener<AppListBean>() {
          @Override public void onResponse(AppListBean response) {
            appListBeen = response.getApplist();
            appListAdapter = new AppListAdapter(response.getApplist());
            appListAdapter.setmListener(ViewPagerTabListViewFragment.this);
            scroll.setAdapter(appListAdapter);
          }
        }, new Response.ErrorListener() {
          @Override public void onErrorResponse(VolleyError error) {
          }
        });

    MarketApplication.addRequest(gsonGetRequest, TAG);
  }

  DownloadInfo downloadInfo = new DownloadInfo();

  @Override public void onDownloadClick(View view, int position, AppInfoBean app) {

    downloadInfo.setState(HttpHandler.State.SUCCESS);
    HttpHandler.State state = downloadInfo.getState();
    switch (state) {
      case WAITING:

      case STARTED:
      case LOADING:
        try {
          MarketApplication.getDownloadManager().stopDownload(downloadInfo);
        } catch (DbException e) {
          LogUtils.e(e.getMessage(), e);
        }
        break;
      case CANCELLED:

      case FAILURE:
        try {
          MarketApplication.getDownloadManager().resumeDownload(downloadInfo, new DownloadRequestCallBack());
        } catch (DbException e) {
          LogUtils.e(e.getMessage(), e);
        }
        break;
      default:
        String target = "/sdcard/xUtils/" + System.currentTimeMillis() + app.getName() + ".apk";
        try {
          MarketApplication.getDownloadManager()
              .addNewDownload(ApiHelper.getDownUrl(app.getId()), app.getName(), target, true, true, app.getIcon(), app.getVer(),
                  app.getId(), new DownloadRequestCallBack(), downloadInfo);
        } catch (DbException e) {
          e.printStackTrace();
        }
        break;
    }
  }

  @Override public void onItemClick(View view, int position, AppInfoBean app) {

  }
}
