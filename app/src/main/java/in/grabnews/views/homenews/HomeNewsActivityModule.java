package in.grabnews.views.homenews;

import android.support.v7.widget.LinearLayoutManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;

@Module
public class HomeNewsActivityModule {
    @Provides
    HomeNewsViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new HomeNewsViewModel(dataManager, schedulerProvider);
    }

    @Provides
    NewsAdapter provideLiveDataAdapter() {
        return new NewsAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(HomeNewsActivity liveDataActivity) {
        return new LinearLayoutManager(liveDataActivity);
    }


    @Provides
    WeakReference<HomeNewsActivity> provideWeakReferenceContext(HomeNewsActivity activity) {
        return new WeakReference<>(activity);
    }
}
