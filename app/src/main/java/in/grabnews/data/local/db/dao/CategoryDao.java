package in.grabnews.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import in.grabnews.data.model.db.Category;

@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Category> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category category);

    @Query("SELECT * FROM category")
    List<Category> loadAll();

    @Query("DELETE FROM category")
    public void deleteAll();
}
