package in.grabnews.views.webview;

import in.grabnews.data.DataManager;
import in.grabnews.databinding.ActivityWebViewBinding;
import in.grabnews.utils.rx.SchedulerProvider;
import in.grabnews.views.base.BaseViewModel;

public class NewsDetailsViewModel extends BaseViewModel {

    public NewsDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
