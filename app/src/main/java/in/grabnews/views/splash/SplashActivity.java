package in.grabnews.views.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import javax.inject.Inject;

import in.grabnews.R;
import in.grabnews.databinding.ActivitySplashBinding;
import in.grabnews.utils.AppLogger;
import in.grabnews.views.base.BaseActivity;
import in.grabnews.views.homenews.HomeNewsActivity;
import in.grabnews.BR;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        AppLogger.i("home_activity", "getBindingVariable");
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }


    @Override
    public void openMainActivity() {

        Log.v("home_activity", "openMainActivity");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeNewsActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("home_activity", "onCreate");
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.decideNextActivity();

    }
}
