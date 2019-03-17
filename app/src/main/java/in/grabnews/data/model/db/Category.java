package in.grabnews.data.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "category")
public class Category {
    @Expose
    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
