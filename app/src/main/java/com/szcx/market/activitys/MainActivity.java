package com.szcx.market.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.szcx.market.R;
import com.szcx.market.fragment.ViewPagerTabListViewFragment;
import com.szcx.market.homeinteractive.CacheFragmentStatePagerAdapter;
import com.szcx.market.homeinteractive.ObservableScrollViewCallbacks;
import com.szcx.market.homeinteractive.ScrollState;
import com.szcx.market.homeinteractive.ScrollUtils;
import com.szcx.market.homeinteractive.Scrollable;
import com.szcx.market.homeinteractive.SlidingTabLayout;
import com.szcx.market.homeinteractive.TouchInterceptionFrameLayout;

public class MainActivity extends BaseActivity implements ObservableScrollViewCallbacks {
  private static final boolean ADJUSTTOOLBAR_ENABLE = true;
  private static final boolean SCROLLINGUP_NOW = false;

  private NavigationAdapter mPagerAdapter;
  private int mSlop;
  private boolean mScrolled;
  private ScrollState mLastScrollState;
  private int lp_height = 0;
  private int startAmi;
  private int tabHeight;

  @Bind(R.id.view_toolbar) View view_toolbar;
  @Bind(R.id.toolbar_translationY) View mToolbarView;
  @Bind(R.id.toolbar) View toolbar;
  @Bind(R.id.search) View search;
  @Bind(R.id.pager) ViewPager mPager;
  @Bind(R.id.title_down) ImageView title_down;
  @Bind(R.id.sliding_tabs) SlidingTabLayout slidingTabLayout;
  @Bind(R.id.container) TouchInterceptionFrameLayout mInterceptionLayout;
  @Bind(R.id.pager_wrapper) FrameLayout pager_wrapper;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viewpagertab2);
    ButterKnife.bind(this);
    initview();
    setlistener();
  }

  private void setlistener() {
    title_down.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DownloadList.class);
        startActivity(intent);
      }
    });
  }

  private void initview() {
    String[] tabname = getResources().getStringArray(R.array.tab_main);
    mPagerAdapter = new NavigationAdapter(getSupportFragmentManager(), tabname);
    mPager.setAdapter(mPagerAdapter);

    ViewHelper.setAlpha(toolbar, 0);
    tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
    startAmi = tabHeight * 2 - getTranslationY();
    pager_wrapper.setPadding(0, getTranslationY() + tabHeight * 2, 0, 0);

    slidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
    slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
    slidingTabLayout.setDistributeEvenly(true);
    slidingTabLayout.setViewPager(mPager);

    ViewConfiguration vc = ViewConfiguration.get(this);
    mSlop = vc.getScaledTouchSlop();
    mInterceptionLayout.setScrollInterceptionListener(mInterceptionListener);
  }

  @Override public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
  }

  @Override public void onDownMotionEvent() {
  }

  @Override public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    if (!mScrolled) {
      adjustToolbar(scrollState);
    }
  }

  private TouchInterceptionFrameLayout.TouchInterceptionListener mInterceptionListener =
      new TouchInterceptionFrameLayout.TouchInterceptionListener() {
        @Override public boolean shouldInterceptTouchEvent(MotionEvent ev, boolean moving, float diffX, float diffY) {
          if (!mScrolled && mSlop < Math.abs(diffX) && Math.abs(diffY) < Math.abs(diffX)) {
            return false;
          }

          Scrollable scrollable = getCurrentScrollable();
          if (scrollable == null) {
            mScrolled = false;
            return false;
          }

          int toolbarHeight = mToolbarView.getHeight();
          int translationY = (int) ViewHelper.getTranslationY(mInterceptionLayout);
          boolean scrollingUp = 0 < diffY;
          boolean scrollingDown = diffY < 0;
          if (scrollingUp) {
            if ((SCROLLINGUP_NOW || scrollable.getCurrentScrollY() == 0) && translationY < 0) {
              mScrolled = true;
              mLastScrollState = ScrollState.UP;
              return true;
            }
          } else if (scrollingDown) {

            if (-toolbarHeight < translationY) {
              mScrolled = true;
              mLastScrollState = ScrollState.DOWN;
              return true;
            }
          }
          mScrolled = false;
          return false;
        }

        @Override public void onDownMotionEvent(MotionEvent ev) {
        }

        @Override public void onMoveMotionEvent(MotionEvent ev, float diffX, float diffY) {
          float translationY = ScrollUtils.getFloat(ViewHelper.getTranslationY(mInterceptionLayout) + diffY, -mToolbarView.getHeight(), 0);
          ViewHelper.setTranslationY(mInterceptionLayout, translationY);
          ViewHelper.setTranslationY(view_toolbar, -translationY);
          if (translationY < 0) {
            if (lp_height == 0) {
              FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mInterceptionLayout.getLayoutParams();
              lp.height = (int) (-translationY + getScreenHeight());
              mInterceptionLayout.requestLayout();
            }

            fixView(translationY);
          }
        }

        @Override public void onUpOrCancelMotionEvent(MotionEvent ev) {
          mScrolled = false;
          adjustToolbar(mLastScrollState);
        }
      };

  private void fixView(float translationY) {
    RelativeLayout.LayoutParams params = (LayoutParams) search.getLayoutParams();
    int left = dipToPx(10);
    int right = dipToPx(10);

    float percent = 0;
    if (translationY < startAmi) {
      percent = (startAmi - translationY) / tabHeight / 2;
    }
    ViewHelper.setAlpha(toolbar, percent);

    int abSize = getTranslationY();
    percent = -translationY / abSize;
    left += percent * dipToPx(30);
    right += percent * dipToPx(30);

    params.setMargins(left, params.topMargin, right, params.bottomMargin);
    search.setLayoutParams(params);
  }

  public int dipToPx(int dipValue) {
    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, getResources().getDisplayMetrics());
  }

  private Scrollable getCurrentScrollable() {
    Fragment fragment = getCurrentFragment();
    if (fragment == null) {
      return null;
    }
    View view = fragment.getView();
    if (view == null) {
      return null;
    }
    return (Scrollable) view.findViewById(R.id.scroll);
  }

  private void adjustToolbar(ScrollState scrollState) {
    if (!ADJUSTTOOLBAR_ENABLE) return;
    int toolbarHeight = mToolbarView.getHeight();
    final Scrollable scrollable = getCurrentScrollable();
    if (scrollable == null) {
      return;
    }
    int scrollY = scrollable.getCurrentScrollY();
    if (scrollState == ScrollState.DOWN) {
      showToolbar();
    } else if (scrollState == ScrollState.UP) {
      if (toolbarHeight <= scrollY) {
        hideToolbar();
      } else {
        showToolbar();
      }
    } else if (!toolbarIsShown() && !toolbarIsHidden()) {
      showToolbar();
    }
  }

  private Fragment getCurrentFragment() {
    return mPagerAdapter.getItemAt(mPager.getCurrentItem());
  }

  private boolean toolbarIsShown() {
    return ViewHelper.getTranslationY(mInterceptionLayout) == 0;
  }

  private boolean toolbarIsHidden() {
    return ViewHelper.getTranslationY(mInterceptionLayout) == -mToolbarView.getHeight();
  }

  private void showToolbar() {
    if (!toolbarIsShown() && !toolbarIsHidden()) animateToolbar(0);
  }

  private void hideToolbar() {
    animateToolbar(-mToolbarView.getHeight());
  }

  private void animateToolbar(final float toY) {
    float layoutTranslationY = ViewHelper.getTranslationY(mInterceptionLayout);
    if (layoutTranslationY != toY) {
      ValueAnimator animator = ValueAnimator.ofFloat(ViewHelper.getTranslationY(mInterceptionLayout), toY).setDuration(200);
      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          float translationY = (Float) animation.getAnimatedValue();
          ViewHelper.setTranslationY(mInterceptionLayout, translationY);
          ViewHelper.setTranslationY(view_toolbar, -translationY);

          fixView(translationY);
        }
      });
      animator.start();
    }
  }

  private static class NavigationAdapter extends CacheFragmentStatePagerAdapter {
    String[] tabname;

    public NavigationAdapter(FragmentManager fm, String[] tabname) {
      super(fm);
      this.tabname = tabname;
    }

    @Override protected Fragment createItem(int position) {
      Fragment f;
      final int pattern = position % 5;
      switch (pattern) {
        case 0:
          f = new ViewPagerTabListViewFragment();
          break;
        case 1:
          f = new ViewPagerTabListViewFragment();
          break;
        case 2:
          f = new ViewPagerTabListViewFragment();
          break;
        case 3:
          f = new ViewPagerTabListViewFragment();
          break;
        case 4:
        default:
          f = new ViewPagerTabListViewFragment();
          break;
      }
      return f;
    }

    @Override public int getCount() {
      return tabname.length;
    }

    @Override public CharSequence getPageTitle(int position) {
      return tabname[position];
    }
  }
}
