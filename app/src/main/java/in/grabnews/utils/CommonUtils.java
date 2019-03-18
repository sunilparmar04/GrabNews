package in.grabnews.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.grabnews.R;
import in.grabnews.data.model.db.Category;
import in.grabnews.data.model.db.Country;

public class CommonUtils {

    public static CommonUtils mInstance;
    public static int RED_COLOR = Color.argb(0xFF, 0xE1, 0x43, 0x1f);

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }


    public static synchronized CommonUtils getInstance() {
        if (mInstance == null) {
            mInstance = new CommonUtils();
        }
        return mInstance;
    }

    public boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    public void showChromeCustomTab(Context context) {
        final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";

        ApplicationInfo ai = null;
        boolean appStatus = false;
        boolean isInstalled = isAppInstalled(context, CUSTOM_TAB_PACKAGE_NAME);
        try {
            ai = context.getPackageManager().getApplicationInfo(CUSTOM_TAB_PACKAGE_NAME, 0);
            appStatus = ai.enabled;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        if (isInstalled) {

        } else {

        }

    }


    public List<Country> getDefaultCountry() {

        Country countryIndia = new Country();
        countryIndia.countryName = "India";
        countryIndia.countryCode = "in";

        Country countryUsa = new Country();
        countryUsa.countryName = "USA";
        countryUsa.countryCode = "us";

        Country countryAustralia = new Country();
        countryAustralia.countryName = "Australia";
        countryAustralia.countryCode = "au";

        Country countryCanada = new Country();
        countryCanada.countryName = "Canada";
        countryCanada.countryCode = "ca";

        List list = new ArrayList();
        list.add(countryIndia);
        list.add(countryUsa);
        list.add(countryAustralia);
        list.add(countryCanada);
        return list;
    }

    public List<Category> getDefaultCategory() {

        Category categoryTechnology = new Category();
        categoryTechnology.category = "Technology";

        Category categoryGeneral = new Category();
        categoryGeneral.category = "General";

        Category categoryEntertainment = new Category();
        categoryEntertainment.category = "Entertainment";

        Category categoryHealth = new Category();
        categoryHealth.category = "Health";

        Category categoryScience = new Category();
        categoryScience.category = "Science";

        Category categorySports = new Category();
        categorySports.category = "Sports";

        List list = new ArrayList();
        list.add(categoryTechnology);
        list.add(categoryGeneral);
        list.add(categoryEntertainment);
        list.add(categoryHealth);
        list.add(categoryScience);
        list.add(categorySports);
        return list;
    }

    public void showRedToast(String textToShow, Context ctx, int topOffset) {

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.custome_toast, null);
        layout.setBackgroundColor(RED_COLOR);

        TextView text = (TextView) layout.findViewById(R.id.textToShow);
        text.setPadding(10, 0, 10, 0);
        // Set the Text to show in TextView
        text.setText(textToShow);

        Toast toast = new Toast(ctx);
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, topOffset);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }

}
