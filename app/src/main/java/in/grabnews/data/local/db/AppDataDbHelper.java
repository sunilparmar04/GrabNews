package in.grabnews.data.local.db;

import java.util.List;

import in.grabnews.data.model.db.NewsArticles;
import io.reactivex.Observable;

public interface AppDataDbHelper {
    Observable<List<NewsArticles>> getAllNewsArticles();

    Observable<Boolean> isNewsArticlesEmpty();

    void saveNewsArticlesList(List<NewsArticles> optionList);

}
