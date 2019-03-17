package in.grabnews.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import in.grabnews.data.model.db.Country;

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Country> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Country country);

    @Query("SELECT * FROM country")
    List<Country> loadAll();

    @Query("DELETE FROM country")
    public void deleteAll();
}
