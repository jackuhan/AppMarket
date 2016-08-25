package com.szcx.market.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.lidroid.xutils.http.HttpHandler;
import com.szcx.market.MarketApplication;
import com.szcx.market.R;
import com.szcx.market.download.DownloadInfo;
import com.szcx.market.models.AppInfoBean;
import com.szcx.market.utils.MyLog;
import com.szcx.market.utils.Sizetransition;
import java.util.ArrayList;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<AppInfoBean> appList;
  private List<DownloadInfo> downloadFinishInfos;//未完成下载的列表

  public AppListAdapter(List<AppInfoBean> appList) {
    downloadFinishInfos = new ArrayList<DownloadInfo>();
    this.appList = appList;
  }

  private OnItemClickListener mListener;
  private List<DownloadInfo> downloadInfoList;//下载列表中的所有下载对象

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_list, parent, false);
    return new AppHolder(view);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    if (holder instanceof AppHolder) {
      final AppInfoBean app = appList.get(position);
      final AppHolder _holder = (AppHolder) holder;
      _holder.tvName.setText(app.getName());
      _holder.tvType.setText(app.getTypename());
      String downloadNum = Sizetransition.FormetunitSize(app.getDmc());
      String msg;
      if (TextUtils.isEmpty(downloadNum)) {
        msg = Sizetransition.FormetFileSize(app.getSize());
      } else {
        msg = downloadNum + "下载 | " + Sizetransition.FormetFileSize(app.getSize());
      }
      _holder.dowload_msg.setText(msg);

      Context context = _holder.itemView.getContext();

      Glide.with(context).load(app.getIcon()).centerCrop().crossFade().into(_holder.ivLogo);
      _holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (mListener != null) {
            mListener.onItemClick(v, _holder.getLayoutPosition(), app);
          }
        }
      });
      _holder.btnDownload.setText("下载");
      _holder.btnDownload.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (mListener != null) {
            mListener.onDownloadClick(v, _holder.getLayoutPosition(), app);
          }
        }
      });
      downloadInfoList = MarketApplication.getDownloadManager().getDownloadInfoList();

      final DownloadInfo downloadInfo = initData(app.getId());

      //HttpHandler<File> handler = downloadInfo.getHandler();
      //if (handler != null) {
      //    DownloadManager.ManagerCallBack requestCallBack = (DownloadManager.ManagerCallBack) handler.getRequestCallBack();
      //    if (requestCallBack.getBaseCallBack() == null) {
      //        requestCallBack.setBaseCallBack(new DownloadRequestCallBack());
      //    }
      //    requestCallBack.setUserTag(new WeakReference<AppHolder>(_holder));
      //}
      //
      //HttpHandler.State state = downloadInfo.getState();
      //switch (state) {
      //  case WAITING:
      //    _holder.btnDownload.setText("暂停");
      //    break;
      //  case STARTED:
      //    _holder.btnDownload.setText("连接中");
      //    break;
      //  case LOADING:
      //    _holder.btnDownload.setText("下载中");
      //    break;
      //  case CANCELLED:
      //    _holder.btnDownload.setText("继续");
      //    break;
      //  case SUCCESS:
      //    _holder.btnDownload.setText("安装");
      //    break;
      //  case FAILURE:
      //    _holder.btnDownload.setText("重试");
      //    break;
      //}
    }
  }

  /**
   * 初始化下载完成/正在下载集合中的数据
   */
  public DownloadInfo initData(final int appid) {
    downloadFinishInfos.clear();
    for (int i = 0; i < downloadInfoList.size(); i++) {
      if (downloadInfoList.get(i).getId() == appid) {
        MyLog.i(downloadInfoList.get(i).getId());
        return downloadInfoList.get(i);
      }
    }
    return null;
  }

  @Override public int getItemCount() {
    return appList.size();
  }

  public static class AppHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.ivLogo) ImageView ivLogo;
    @Bind(R.id.tvName) TextView tvName;
    @Bind(R.id.btnDownload) Button btnDownload;
    @Bind(R.id.tvType) TextView tvType;
    @Bind(R.id.dowload_msg) TextView dowload_msg;

    AppHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }

  public void setmListener(OnItemClickListener mListener) {
    this.mListener = mListener;
  }

  public interface OnItemClickListener {
    void onDownloadClick(View view, int position, AppInfoBean app);

    void onItemClick(View view, int position, AppInfoBean app);
  }
}
