package in.grabnews.views.webview;

import dagger.Module;
import dagger.Provides;
import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;

@Module
public class NewsDetailsActivityModule {

    @Provides
    NewsDetailsViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new NewsDetailsViewModel(dataManager, schedulerProvider);
    }

}
