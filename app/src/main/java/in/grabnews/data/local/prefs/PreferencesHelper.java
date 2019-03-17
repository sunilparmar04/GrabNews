package in.grabnews.data.local.prefs;

public interface PreferencesHelper {

    //add methods

    void setSelectedCountry(Object selectedCountry);

    public <T> T getSelectedCountry(Class<T> mModelClass);

    void setSelectedCategory(String selectedCategory);

    String getSelectedCategory();
}
