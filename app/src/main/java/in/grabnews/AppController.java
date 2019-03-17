package in.grabnews;

import android.app.Activity;
import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import in.grabnews.di.component.DaggerAppComponent;
import in.grabnews.utils.AppLogger;

public class AppController extends Application implements HasActivityInjector {

    public static AppController mInstance;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
        mInstance = this;

        AppLogger.init();
    }


    public static synchronized AppController getInstace() {

        if (mInstance == null) {
            mInstance = new AppController();
        }

        return mInstance;
    }
}
