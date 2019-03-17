package in.grabnews.views.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import java.lang.ref.WeakReference;

import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel<N> extends ViewModel {

    private final DataManager mDataManager;

    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;


    public BaseViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();

    }


    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }


    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);

    }


    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
