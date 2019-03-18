package in.grabnews.views.splash;

import dagger.Module;
import dagger.Provides;
import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;


@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new SplashViewModel( dataManager,schedulerProvider);
    }
}
