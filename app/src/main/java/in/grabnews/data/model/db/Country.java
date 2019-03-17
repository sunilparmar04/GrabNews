package in.grabnews.data.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "country")
public class Country {
    @Expose
    @PrimaryKey(autoGenerate = true)
    public Long id;
    public String countryName;
    public String countryCode;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
