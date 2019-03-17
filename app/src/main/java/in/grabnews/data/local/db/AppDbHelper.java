package in.grabnews.data.local.db;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.grabnews.data.model.db.NewsArticles;
import io.reactivex.Observable;


@Singleton
public class AppDbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    public Observable<List<NewsArticles>> getAllNewsArticles() {
        return Observable.fromCallable(new Callable<List<NewsArticles>>() {
            @Override
            public List<NewsArticles> call() throws Exception {
                return mAppDatabase.newsArticlesDao().loadAll();
            }
        });
    }

    public Observable<Boolean> isNewsArticlesEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.newsArticlesDao().loadAll().isEmpty();
            }
        });
    }

    public void saveNewsArticlesList(final List<NewsArticles> newsArticlesList) {
        mAppDatabase.newsArticlesDao().deleteAll();
        mAppDatabase.newsArticlesDao().insertAll(newsArticlesList);
    }

}
