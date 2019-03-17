package in.grabnews.utils;

public class AppConstants {
    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "grabNews.db";
    public static final String NEWS_DETAILS_URL="news_details_url";

    public static final long NULL_INDEX = -1L;

    public static final String PREF_NAME = "grab_news_pref";

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";

    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String STATUS_CODE_FAILED = "failed";

    public static final String STATUS_CODE_SUCCESS = "success";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";



    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String APPLICATION_ID = "com.mvvmdemo";
    public static final String BUILD_TYPE = "debug";
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";
    // Fields from build type: debug
    public static final String API_KEY = "c1bb14c3c36d4162b21a7378d56fd918";
    public static final String BASE_URL = "https://newsapi.org/v2/top-headlines";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
