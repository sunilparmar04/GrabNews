package in.grabnews.views.homenews;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import in.grabnews.BR;
import in.grabnews.BuildConfig;
import in.grabnews.R;
import in.grabnews.data.model.db.Category;
import in.grabnews.data.model.db.Country;
import in.grabnews.databinding.ActivityHomeNewsBinding;
import in.grabnews.databinding.NavHeaderMainBinding;
import in.grabnews.utils.AppLogger;
import in.grabnews.utils.CommonUtils;
import in.grabnews.views.base.BaseActivity;

public class HomeNewsActivity extends BaseActivity<ActivityHomeNewsBinding, HomeNewsViewModel> implements HomeNewsNavigator {

    @Inject
    HomeNewsViewModel mHomeNewsViewModel;

    @Inject
    LinearLayoutManager mLayoutManager;

    ActivityHomeNewsBinding activityHomeNewsBinding;
    @Inject
    NewsAdapter mNewsAdapter;
    private DrawerLayout mDrawer;

    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_news;
    }

    @Override
    public HomeNewsViewModel getViewModel() {
        return mHomeNewsViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeNewsBinding = getViewDataBinding();
        AppLogger.i("home_activity", "onCreate");
        mHomeNewsViewModel.setNavigator(this);
        initViews();
        setUpMenu();
        mHomeNewsViewModel.checkLocalData();
    }

    private void initViews() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        activityHomeNewsBinding.newsRecyclerView.setLayoutManager(mLayoutManager);
        activityHomeNewsBinding.newsRecyclerView.setAdapter(mNewsAdapter);
    }

    private void setUpMenu() {
        mDrawer = activityHomeNewsBinding.drawerView;
        mToolbar = activityHomeNewsBinding.toolbar;
        mNavigationView = activityHomeNewsBinding.navigationView;

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };

        mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        mHomeNewsViewModel.updateAppVersion(version);
        mHomeNewsViewModel.setDefaultCountryCategory();

    }

    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, activityHomeNewsBinding.navigationView, false);
        activityHomeNewsBinding.navigationView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mHomeNewsViewModel);

        mNavigationView.setNavigationItemSelectedListener(
                item -> {
                    mDrawer.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {

                        case R.id.navItemHome:
                            return true;
                        default:
                            return false;
                    }
                });
    }

    @Override
    public void showCountryDialog() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle(getString(R.string.title_country));
        List<Country> country = CommonUtils.getInstance().getDefaultCountry();
        ListAdapter adapter = new ArrayAdapter<List<Country>>(this, android.R.layout.select_dialog_singlechoice) {

            ViewHolder holder;


            class ViewHolder {

                TextView title;
            }

            public View getView(int position, View convertView,
                                ViewGroup parent) {
                final LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);

                if (convertView == null) {
                    convertView = inflater.inflate(
                            android.R.layout.select_dialog_singlechoice, null);

                    holder = new ViewHolder();

                    holder.title = (TextView) convertView
                            .findViewById(android.R.id.text1);
                    convertView.setTag(holder);
                } else {
                    // view already defined, retrieve view holder
                    holder = (ViewHolder) convertView.getTag();
                }

                holder.title.setText(country.get(position).countryName);

                return convertView;
            }

            @Override
            public int getCount() {
                return country.size();
            }
        };
        builderSingle.setNegativeButton(getString(R.string.button_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                Country selectedCountry = country.get(position);
                AppLogger.i("news_response", "selected country:" + selectedCountry.countryCode);
                mHomeNewsViewModel.saveSelectedCoutryCode(selectedCountry);
            }
        });
        builderSingle.show();
    }

    @Override
    public void showCategoryDialog() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle(getString(R.string.title_category));
        List<Category> categoryList = CommonUtils.getInstance().getDefaultCategory();
        ListAdapter adapter = new ArrayAdapter<List<Category>>(this, android.R.layout.select_dialog_singlechoice) {

            ViewHolder holder;


            class ViewHolder {

                TextView title;
            }

            public View getView(int position, View convertView,
                                ViewGroup parent) {
                final LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);

                if (convertView == null) {
                    convertView = inflater.inflate(
                            android.R.layout.select_dialog_singlechoice, null);

                    holder = new ViewHolder();

                    holder.title = (TextView) convertView
                            .findViewById(android.R.id.text1);
                    convertView.setTag(holder);
                } else {
                    // view already defined, retrieve view holder
                    holder = (ViewHolder) convertView.getTag();
                }

                holder.title.setText(categoryList.get(position).category);

                return convertView;
            }

            @Override
            public int getCount() {
                return categoryList.size();
            }
        };
        builderSingle.setNegativeButton(getString(R.string.button_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                Category selectedCategory = categoryList.get(position);
                Log.v("news_response", "selected country:" + selectedCategory.getCategory());
                mHomeNewsViewModel.saveSelectedCategory(selectedCategory);
            }
        });
        builderSingle.show();
    }
}
