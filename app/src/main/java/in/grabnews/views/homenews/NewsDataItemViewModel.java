package in.grabnews.views.homenews;

import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import in.grabnews.AppController;
import in.grabnews.R;
import in.grabnews.data.model.db.NewsArticles;
import in.grabnews.utils.AppConstants;
import in.grabnews.utils.CommonUtils;
import in.grabnews.utils.NetworkUtils;
import in.grabnews.views.webview.NewsDetailsActivity;

public class NewsDataItemViewModel {

    public final ObservableField<NewsArticles> newsArticlesField;
    public final ObservableField<String> autherName;
    private final ObservableBoolean mIsContentVisible = new ObservableBoolean(false);


    public final LiveDataModelListener mListener;


    public NewsDataItemViewModel(NewsArticles name, LiveDataModelListener mListener) {
        this.newsArticlesField = new ObservableField<>(name);
        this.mListener = mListener;

        if (newsArticlesField.get().getAuthor() == null || newsArticlesField.get().getAuthor().contains("http") || newsArticlesField.get().getAuthor().contains("https")) {
            autherName = new ObservableField<>("");
        } else {
            autherName = new ObservableField<>(newsArticlesField.get().getAuthor());
        }

        if (newsArticlesField.get().getContent() == null || newsArticlesField.get().getContent().isEmpty()) {
            setIsLoading(false);
        } else {
            setIsLoading(true);
        }

    }

    public void onItemClick() {
        if (NetworkUtils.isNetworkConnected(AppController.getInstace())) {
            Intent gotoNewsDetails = new Intent(AppController.getInstace(), NewsDetailsActivity.class);
            gotoNewsDetails.putExtra(AppConstants.NEWS_DETAILS_URL, newsArticlesField.get().getUrl());
            AppController.getInstace().startActivity(gotoNewsDetails);
        } else {
            CommonUtils.getInstance().showRedToast(AppController.getInstace().getString(R.string.error_internet), AppController.mInstance, 112);
        }


    }


    public interface LiveDataModelListener {

        void onItemClick(String name);
    }

    public ObservableBoolean getIsLoading() {
        return mIsContentVisible;
    }

    public void setIsLoading(boolean isLoading) {
        mIsContentVisible.set(isLoading);
    }

}
