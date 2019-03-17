package in.grabnews.data.local.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import in.grabnews.data.model.db.NewsArticles;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class NewsArticlesDao_Impl implements NewsArticlesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfNewsArticles;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NewsArticlesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNewsArticles = new EntityInsertionAdapter<NewsArticles>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `articles`(`id`,`author`,`title`,`description`,`url`,`urlToImage`,`publishedAt`,`content`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsArticles value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
        if (value.getUrlToImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUrlToImage());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublishedAt());
        }
        if (value.getContent() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getContent());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM articles";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(List<NewsArticles> articles) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfNewsArticles.insert(articles);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(NewsArticles articles) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfNewsArticles.insert(articles);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<NewsArticles> loadAll() {
    final String _sql = "SELECT * FROM articles";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfAuthor = _cursor.getColumnIndexOrThrow("author");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfUrl = _cursor.getColumnIndexOrThrow("url");
      final int _cursorIndexOfUrlToImage = _cursor.getColumnIndexOrThrow("urlToImage");
      final int _cursorIndexOfPublishedAt = _cursor.getColumnIndexOrThrow("publishedAt");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final List<NewsArticles> _result = new ArrayList<NewsArticles>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NewsArticles _item;
        _item = new NewsArticles();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpAuthor;
        _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
        _item.setAuthor(_tmpAuthor);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        _item.setUrl(_tmpUrl);
        final String _tmpUrlToImage;
        _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
        _item.setUrlToImage(_tmpUrlToImage);
        final String _tmpPublishedAt;
        _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
        _item.setPublishedAt(_tmpPublishedAt);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        _item.setContent(_tmpContent);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
