package in.grabnews.data;

import android.content.Context;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.grabnews.data.local.db.AppDbHelper;
import in.grabnews.data.local.prefs.PreferencesHelper;
import in.grabnews.data.model.NewsRequest;
import in.grabnews.data.model.NewsResponse;
import in.grabnews.data.model.db.NewsArticles;
import in.grabnews.data.remote.ApiHeader;
import in.grabnews.data.remote.ApiHelper;
import in.grabnews.utils.AppLogger;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    private final AppDbHelper mAppDbHelper;


    @Inject
    public AppDataManager(Context context, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson, AppDbHelper appDbHelpers) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
        mAppDbHelper = appDbHelpers;

    }

    @Override
    public Single<NewsResponse> doGetNewsApiCall(NewsRequest.NewsParamsRequest request) {
        return mApiHelper.doGetNewsApiCall(request);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public void newsResponse(NewsResponse response) {
        AppLogger.i("news_response", "res:" + response.getStatusCode() + "Total Results:" + response.getTotalResults() + "List:" + response.getArticles().get(0).getTitle());
    }

    @Override
    public Observable<List<NewsArticles>> getAllNewsArticles() {
        return mAppDbHelper.getAllNewsArticles();
    }

    @Override
    public Observable<Boolean> isNewsArticlesEmpty() {
        return mAppDbHelper.isNewsArticlesEmpty();
    }

    @Override
    public void saveNewsArticlesList(List<NewsArticles> optionList) {
        mAppDbHelper.saveNewsArticlesList(optionList);
    }

    @Override
    public void setSelectedCountry(Object selectedCountry) {
        mPreferencesHelper.setSelectedCountry(selectedCountry);
    }

    @Override
    public <T> T getSelectedCountry(Class<T> mModelClass) {
        return mPreferencesHelper.getSelectedCountry(mModelClass);
    }

    @Override
    public void setSelectedCategory(String selectedCategory) {

        mPreferencesHelper.setSelectedCategory(selectedCategory);
    }

    @Override
    public String getSelectedCategory() {
        return mPreferencesHelper.getSelectedCategory();
    }

}
