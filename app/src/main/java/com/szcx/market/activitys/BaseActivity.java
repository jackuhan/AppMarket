package com.szcx.market.activitys;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.szcx.market.R;

public abstract class BaseActivity extends FragmentActivity {
  public String TAG = this.getClass().getSimpleName();

  protected int getTranslationY() {
    return getResources().getDimensionPixelSize(R.dimen.translationY);
  }

  protected int getScreenHeight() {
    return findViewById(android.R.id.content).getHeight();
  }

  @Override protected void onResume() {
    super.onResume();
    Log.v(TAG,"onResume");
  }
}
