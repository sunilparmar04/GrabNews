package in.grabnews.views.splash;

import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;
import in.grabnews.views.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void decideNextActivity() {
        getNavigator().openMainActivity();
    }

}
