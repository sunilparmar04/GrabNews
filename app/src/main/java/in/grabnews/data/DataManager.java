package in.grabnews.data;

import in.grabnews.data.local.db.AppDataDbHelper;
import in.grabnews.data.local.prefs.PreferencesHelper;
import in.grabnews.data.model.NewsResponse;
import in.grabnews.data.remote.ApiHelper;

public interface DataManager extends ApiHelper, AppDataDbHelper, PreferencesHelper {

    void newsResponse(NewsResponse response);

}
