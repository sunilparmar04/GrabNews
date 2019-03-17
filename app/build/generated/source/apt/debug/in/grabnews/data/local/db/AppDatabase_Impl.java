package in.grabnews.data.local.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import in.grabnews.data.local.db.dao.NewsArticlesDao;
import in.grabnews.data.local.db.dao.NewsArticlesDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class AppDatabase_Impl extends AppDatabase {
  private volatile NewsArticlesDao _newsArticlesDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `articles` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `author` TEXT, `title` TEXT, `description` TEXT, `url` TEXT, `urlToImage` TEXT, `publishedAt` TEXT, `content` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"04c93caab8b6e1c7ff44f752cda57803\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `articles`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsArticles = new HashMap<String, TableInfo.Column>(8);
        _columnsArticles.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsArticles.put("author", new TableInfo.Column("author", "TEXT", false, 0));
        _columnsArticles.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsArticles.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsArticles.put("url", new TableInfo.Column("url", "TEXT", false, 0));
        _columnsArticles.put("urlToImage", new TableInfo.Column("urlToImage", "TEXT", false, 0));
        _columnsArticles.put("publishedAt", new TableInfo.Column("publishedAt", "TEXT", false, 0));
        _columnsArticles.put("content", new TableInfo.Column("content", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysArticles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesArticles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoArticles = new TableInfo("articles", _columnsArticles, _foreignKeysArticles, _indicesArticles);
        final TableInfo _existingArticles = TableInfo.read(_db, "articles");
        if (! _infoArticles.equals(_existingArticles)) {
          throw new IllegalStateException("Migration didn't properly handle articles(in.grabnews.data.model.db.NewsArticles).\n"
                  + " Expected:\n" + _infoArticles + "\n"
                  + " Found:\n" + _existingArticles);
        }
      }
    }, "04c93caab8b6e1c7ff44f752cda57803");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "articles");
  }

  @Override
  public NewsArticlesDao newsArticlesDao() {
    if (_newsArticlesDao != null) {
      return _newsArticlesDao;
    } else {
      synchronized(this) {
        if(_newsArticlesDao == null) {
          _newsArticlesDao = new NewsArticlesDao_Impl(this);
        }
        return _newsArticlesDao;
      }
    }
  }
}
