package in.grabnews.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

import javax.inject.Inject;

import in.grabnews.di.PreferenceInfo;


public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_SELECTED_COUNTRY_CODE = "PREF_KEY_SELECTED_COUNTRY_CODE";
    private static final String PREF_KEY_SELECTED_CATEGORY = "PREF_KEY_SELECTED_CATEGORY";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void setSelectedCountry(Object selectedCountry) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_COUNTRY_CODE, new Gson().toJson(selectedCountry)).commit();
    }


    @Override
    public <T> T getSelectedCountry(Class<T> mModelClass) {

        Object object = null;
        try {
            object = new Gson().fromJson(mPrefs.getString(PREF_KEY_SELECTED_COUNTRY_CODE, ""), mModelClass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Primitives.wrap(mModelClass).cast(object);

    }

    @Override
    public void setSelectedCategory(String selectedCategory) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_CATEGORY, selectedCategory).commit();
    }

    @Override
    public String getSelectedCategory() {
        return mPrefs.getString(PREF_KEY_SELECTED_CATEGORY, "General");
    }


}
