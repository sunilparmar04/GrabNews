package in.grabnews.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import in.grabnews.data.model.db.NewsArticles;

@Dao
public interface NewsArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NewsArticles> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NewsArticles articles);

    @Query("SELECT * FROM articles")
    List<NewsArticles> loadAll();

    @Query("DELETE FROM articles")
    public void deleteAll();
}
