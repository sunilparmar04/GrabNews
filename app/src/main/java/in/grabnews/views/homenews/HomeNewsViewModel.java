package in.grabnews.views.homenews;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import in.grabnews.AppController;
import in.grabnews.R;
import in.grabnews.data.DataManager;
import in.grabnews.data.model.NewsRequest;
import in.grabnews.data.model.db.Category;
import in.grabnews.data.model.db.Country;
import in.grabnews.data.model.db.NewsArticles;
import in.grabnews.utils.AppLogger;
import in.grabnews.utils.CommonUtils;
import in.grabnews.utils.NetworkUtils;
import in.grabnews.utils.rx.SchedulerProvider;
import in.grabnews.views.base.BaseViewModel;

public class HomeNewsViewModel extends BaseViewModel<HomeNewsNavigator> {
    public final ObservableArrayList<NewsArticles> liveNewsObservableArrayList = new ObservableArrayList<>();
    private final ObservableField<String> appVersion = new ObservableField<>();
    private ObservableField<String> countryCode = new ObservableField<>();
    private ObservableField<String> newsCategory = new ObservableField<>();

    public HomeNewsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onGetNews() {

        if (liveNewsObservableArrayList.size() == 0) {
            setIsLoading(true);
        }

        getCompositeDisposable().add(getDataManager()
                .doGetNewsApiCall(new NewsRequest.NewsParamsRequest(getDataManager()))
                .doOnSuccess(response -> {
                            getDataManager()
                                    .newsResponse(response);
                            getDataManager().saveNewsArticlesList(response.getArticles());
                            liveNewsObservableArrayList.clear();
                            liveNewsObservableArrayList.addAll(response.getArticles());
                        }
                )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    // getNavigator().handleError(throwable);
                }));
    }

    public void addLiveItemsToList(ArrayList<NewsArticles> responseList) {
        liveNewsObservableArrayList.clear();
        liveNewsObservableArrayList.addAll(responseList);
    }

    public ObservableList<NewsArticles> getLiveObservableList() {
        return liveNewsObservableArrayList;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public void checkLocalData() {
        //run on separate thread so that UI thread won't block
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Log.i("news_response","Thread:"+Thread.currentThread().getId());
                AppLogger.i("news_response", "Network status:" + NetworkUtils.isNetworkConnected(AppController.getInstace()) + "Local:" + getDataManager().isNewsArticlesEmpty().blockingFirst());
                if (getDataManager().isNewsArticlesEmpty().blockingFirst() || NetworkUtils.isNetworkConnected(AppController.getInstace())) {

                    if (!NetworkUtils.isNetworkConnected(AppController.getInstace())) {
                        CommonUtils.getInstance().showRedToast(AppController.getInstace().getString(R.string.error_internet), AppController.mInstance, 112);
                    } else {
                        onGetNews();
                    }
                } else {
                    List<NewsArticles> articlesArrayLists = getDataManager().getAllNewsArticles().blockingFirst();
                    AppLogger.i("news_response", "news size:" + articlesArrayLists.size());
                    if (articlesArrayLists.size() > 0) {
                        liveNewsObservableArrayList.clear();
                        liveNewsObservableArrayList.addAll(articlesArrayLists);
                    }
                    if (NetworkUtils.isNetworkConnected(AppController.getInstace())) {
                        onGetNews();
                    } else {
                        if (!NetworkUtils.isNetworkConnected(AppController.getInstace())) {

                            CommonUtils.getInstance().showRedToast(AppController.getInstace().getString(R.string.error_internet), AppController.mInstance, 112);
                        }
                    }
                }

                Looper.loop();
            }
        }).start();
    }

    public void onSelectCountry() {
        getNavigator().showCountryDialog();
    }

    public void onSelectCategory() {
        getNavigator().showCategoryDialog();
    }

    public void saveSelectedCoutryCode(Country country) {
        countryCode.set(country.countryName);
        getDataManager().setSelectedCountry(country);

        if (!NetworkUtils.isNetworkConnected(AppController.getInstace())) {
            CommonUtils.getInstance().showRedToast(AppController.getInstace().getString(R.string.error_internet), AppController.mInstance, 112);
            return;
        } else {
            setIsLoading(true);
            onGetNews();
        }

    }

    public ObservableField<String> getCountryCode() {
        return countryCode;
    }

    public void saveSelectedCategory(Category category) {
        newsCategory.set(category.category);
        getDataManager().setSelectedCategory(category.category);
        setIsLoading(true);
        if (!NetworkUtils.isNetworkConnected(AppController.getInstace())) {
            CommonUtils.getInstance().showRedToast(AppController.getInstace().getString(R.string.error_internet), AppController.mInstance, 112);
            return;
        } else {
            setIsLoading(true);
            onGetNews();
        }
    }

    public ObservableField<String> getNewsCategory() {
        return newsCategory;
    }

    public void setDefaultCountryCategory() {
        Country country = getDataManager().getSelectedCountry(Country.class);
        if (country != null && !country.countryName.isEmpty()) {
            countryCode.set(country.countryName);
        } else {
            countryCode.set("India");
        }
        newsCategory.set(getDataManager().getSelectedCategory());
    }

}
