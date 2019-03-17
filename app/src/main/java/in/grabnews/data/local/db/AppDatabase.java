package in.grabnews.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import in.grabnews.data.local.db.dao.NewsArticlesDao;
import in.grabnews.data.model.db.NewsArticles;


@Database(entities = {NewsArticles.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NewsArticlesDao newsArticlesDao();

}
