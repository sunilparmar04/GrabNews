// Generated by Dagger (https://google.github.io/dagger).
package in.grabnews.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.google.gson.Gson;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import in.grabnews.AppController;
import in.grabnews.AppController_MembersInjector;
import in.grabnews.data.AppDataManager;
import in.grabnews.data.AppDataManager_Factory;
import in.grabnews.data.DataManager;
import in.grabnews.data.local.db.AppDatabase;
import in.grabnews.data.local.db.AppDbHelper;
import in.grabnews.data.local.db.AppDbHelper_Factory;
import in.grabnews.data.local.prefs.AppPreferencesHelper_Factory;
import in.grabnews.data.local.prefs.PreferencesHelper;
import in.grabnews.data.remote.ApiHeader;
import in.grabnews.data.remote.ApiHeader_Factory;
import in.grabnews.data.remote.ApiHeader_PublicApiHeader_Factory;
import in.grabnews.data.remote.ApiHelper;
import in.grabnews.data.remote.AppApiHelper;
import in.grabnews.data.remote.AppApiHelper_Factory;
import in.grabnews.di.builder.ActivityBuilder_BindHomeNewsActivity;
import in.grabnews.di.builder.ActivityBuilder_BindNewsDetailsActivity;
import in.grabnews.di.module.AppModule;
import in.grabnews.di.module.AppModule_ProvideApiHelperFactory;
import in.grabnews.di.module.AppModule_ProvideApiKeyFactory;
import in.grabnews.di.module.AppModule_ProvideAppDatabaseFactory;
import in.grabnews.di.module.AppModule_ProvideContextFactory;
import in.grabnews.di.module.AppModule_ProvideDataManagerFactory;
import in.grabnews.di.module.AppModule_ProvideDatabaseNameFactory;
import in.grabnews.di.module.AppModule_ProvideGsonFactory;
import in.grabnews.di.module.AppModule_ProvidePreferenceNameFactory;
import in.grabnews.di.module.AppModule_ProvidePreferencesHelperFactory;
import in.grabnews.di.module.AppModule_ProvideProtectedApiHeaderFactory;
import in.grabnews.di.module.AppModule_ProvideSchedulerProviderFactory;
import in.grabnews.views.homenews.HomeNewsActivity;
import in.grabnews.views.homenews.HomeNewsActivityModule;
import in.grabnews.views.homenews.HomeNewsActivityModule_ProvideLinearLayoutManagerFactory;
import in.grabnews.views.homenews.HomeNewsActivityModule_ProvideLiveDataAdapterFactory;
import in.grabnews.views.homenews.HomeNewsActivityModule_ProvideSplashViewModelFactory;
import in.grabnews.views.homenews.HomeNewsActivity_MembersInjector;
import in.grabnews.views.homenews.HomeNewsViewModel;
import in.grabnews.views.webview.NewsDetailsActivity;
import in.grabnews.views.webview.NewsDetailsActivityModule;
import in.grabnews.views.webview.NewsDetailsActivityModule_ProvideSplashViewModelFactory;
import in.grabnews.views.webview.NewsDetailsActivity_MembersInjector;
import in.grabnews.views.webview.NewsDetailsViewModel;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerAppComponent implements AppComponent {
  private AppModule appModule;

  private Provider<ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent.Builder>
      homeNewsActivitySubcomponentBuilderProvider;

  private Provider<ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent.Builder>
      newsDetailsActivitySubcomponentBuilderProvider;

  private Provider<Application> applicationProvider;

  private Provider<Context> provideContextProvider;

  private AppModule_ProvidePreferenceNameFactory providePreferenceNameProvider;

  private AppPreferencesHelper_Factory appPreferencesHelperProvider;

  private Provider<PreferencesHelper> providePreferencesHelperProvider;

  private AppModule_ProvideApiKeyFactory provideApiKeyProvider;

  private ApiHeader_PublicApiHeader_Factory publicApiHeaderProvider;

  private Provider<ApiHeader.ProtectedApiHeader> provideProtectedApiHeaderProvider;

  private Provider<ApiHeader> apiHeaderProvider;

  private Provider<AppApiHelper> appApiHelperProvider;

  private Provider<ApiHelper> provideApiHelperProvider;

  private Provider<Gson> provideGsonProvider;

  private AppModule_ProvideDatabaseNameFactory provideDatabaseNameProvider;

  private Provider<AppDatabase> provideAppDatabaseProvider;

  private Provider<AppDbHelper> appDbHelperProvider;

  private Provider<AppDataManager> appDataManagerProvider;

  private Provider<DataManager> provideDataManagerProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
      getMapOfClassOfAndProviderOfFactoryOf() {
    return MapBuilder
        .<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
            newMapBuilder(2)
        .put(HomeNewsActivity.class, (Provider) homeNewsActivitySubcomponentBuilderProvider)
        .put(NewsDetailsActivity.class, (Provider) newsDetailsActivitySubcomponentBuilderProvider)
        .build();
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        getMapOfClassOfAndProviderOfFactoryOf());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.homeNewsActivitySubcomponentBuilderProvider =
        new Provider<ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent.Builder>() {
          @Override
          public ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent.Builder get() {
            return new HomeNewsActivitySubcomponentBuilder();
          }
        };
    this.newsDetailsActivitySubcomponentBuilderProvider =
        new Provider<
            ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent.Builder>() {
          @Override
          public ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent.Builder
              get() {
            return new NewsDetailsActivitySubcomponentBuilder();
          }
        };
    this.applicationProvider = InstanceFactory.create(builder.application);
    this.provideContextProvider =
        DoubleCheck.provider(
            AppModule_ProvideContextFactory.create(builder.appModule, applicationProvider));
    this.providePreferenceNameProvider =
        AppModule_ProvidePreferenceNameFactory.create(builder.appModule);
    this.appPreferencesHelperProvider =
        AppPreferencesHelper_Factory.create(provideContextProvider, providePreferenceNameProvider);
    this.providePreferencesHelperProvider =
        DoubleCheck.provider(
            AppModule_ProvidePreferencesHelperFactory.create(
                builder.appModule, appPreferencesHelperProvider));
    this.provideApiKeyProvider = AppModule_ProvideApiKeyFactory.create(builder.appModule);
    this.publicApiHeaderProvider = ApiHeader_PublicApiHeader_Factory.create(provideApiKeyProvider);
    this.provideProtectedApiHeaderProvider =
        DoubleCheck.provider(
            AppModule_ProvideProtectedApiHeaderFactory.create(
                builder.appModule, provideApiKeyProvider, providePreferencesHelperProvider));
    this.apiHeaderProvider =
        DoubleCheck.provider(
            ApiHeader_Factory.create(publicApiHeaderProvider, provideProtectedApiHeaderProvider));
    this.appApiHelperProvider =
        DoubleCheck.provider(AppApiHelper_Factory.create(apiHeaderProvider));
    this.provideApiHelperProvider =
        DoubleCheck.provider(
            AppModule_ProvideApiHelperFactory.create(builder.appModule, appApiHelperProvider));
    this.provideGsonProvider =
        DoubleCheck.provider(AppModule_ProvideGsonFactory.create(builder.appModule));
    this.provideDatabaseNameProvider =
        AppModule_ProvideDatabaseNameFactory.create(builder.appModule);
    this.provideAppDatabaseProvider =
        DoubleCheck.provider(
            AppModule_ProvideAppDatabaseFactory.create(
                builder.appModule, provideDatabaseNameProvider, provideContextProvider));
    this.appDbHelperProvider =
        DoubleCheck.provider(AppDbHelper_Factory.create(provideAppDatabaseProvider));
    this.appDataManagerProvider =
        DoubleCheck.provider(
            AppDataManager_Factory.create(
                provideContextProvider,
                providePreferencesHelperProvider,
                provideApiHelperProvider,
                provideGsonProvider,
                appDbHelperProvider));
    this.provideDataManagerProvider =
        DoubleCheck.provider(
            AppModule_ProvideDataManagerFactory.create(builder.appModule, appDataManagerProvider));
    this.appModule = builder.appModule;
  }

  @Override
  public void inject(AppController app) {
    injectAppController(app);
  }

  private AppController injectAppController(AppController instance) {
    AppController_MembersInjector.injectActivityDispatchingAndroidInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private AppModule appModule;

    private Application application;

    @Override
    public AppComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class HomeNewsActivitySubcomponentBuilder
      extends ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent.Builder {
    private HomeNewsActivityModule homeNewsActivityModule;

    private HomeNewsActivity seedInstance;

    @Override
    public ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent build() {
      if (homeNewsActivityModule == null) {
        this.homeNewsActivityModule = new HomeNewsActivityModule();
      }
      if (seedInstance == null) {
        throw new IllegalStateException(HomeNewsActivity.class.getCanonicalName() + " must be set");
      }
      return new HomeNewsActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(HomeNewsActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class HomeNewsActivitySubcomponentImpl
      implements ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent {
    private HomeNewsActivityModule homeNewsActivityModule;

    private HomeNewsActivity seedInstance;

    private HomeNewsActivitySubcomponentImpl(HomeNewsActivitySubcomponentBuilder builder) {
      initialize(builder);
    }

    private HomeNewsViewModel getHomeNewsViewModel() {
      return HomeNewsActivityModule_ProvideSplashViewModelFactory.proxyProvideSplashViewModel(
          homeNewsActivityModule,
          DaggerAppComponent.this.provideDataManagerProvider.get(),
          AppModule_ProvideSchedulerProviderFactory.proxyProvideSchedulerProvider(
              DaggerAppComponent.this.appModule));
    }

    private LinearLayoutManager getLinearLayoutManager() {
      return HomeNewsActivityModule_ProvideLinearLayoutManagerFactory
          .proxyProvideLinearLayoutManager(homeNewsActivityModule, seedInstance);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final HomeNewsActivitySubcomponentBuilder builder) {
      this.homeNewsActivityModule = builder.homeNewsActivityModule;
      this.seedInstance = builder.seedInstance;
    }

    @Override
    public void inject(HomeNewsActivity arg0) {
      injectHomeNewsActivity(arg0);
    }

    private HomeNewsActivity injectHomeNewsActivity(HomeNewsActivity instance) {
      HomeNewsActivity_MembersInjector.injectMHomeNewsViewModel(instance, getHomeNewsViewModel());
      HomeNewsActivity_MembersInjector.injectMLayoutManager(instance, getLinearLayoutManager());
      HomeNewsActivity_MembersInjector.injectMNewsAdapter(
          instance,
          HomeNewsActivityModule_ProvideLiveDataAdapterFactory.proxyProvideLiveDataAdapter(
              homeNewsActivityModule));
      return instance;
    }
  }

  private final class NewsDetailsActivitySubcomponentBuilder
      extends ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent.Builder {
    private NewsDetailsActivityModule newsDetailsActivityModule;

    private NewsDetailsActivity seedInstance;

    @Override
    public ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent build() {
      if (newsDetailsActivityModule == null) {
        this.newsDetailsActivityModule = new NewsDetailsActivityModule();
      }
      if (seedInstance == null) {
        throw new IllegalStateException(
            NewsDetailsActivity.class.getCanonicalName() + " must be set");
      }
      return new NewsDetailsActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(NewsDetailsActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class NewsDetailsActivitySubcomponentImpl
      implements ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent {
    private NewsDetailsActivityModule newsDetailsActivityModule;

    private NewsDetailsActivitySubcomponentImpl(NewsDetailsActivitySubcomponentBuilder builder) {
      initialize(builder);
    }

    private NewsDetailsViewModel getNewsDetailsViewModel() {
      return NewsDetailsActivityModule_ProvideSplashViewModelFactory.proxyProvideSplashViewModel(
          newsDetailsActivityModule,
          DaggerAppComponent.this.provideDataManagerProvider.get(),
          AppModule_ProvideSchedulerProviderFactory.proxyProvideSchedulerProvider(
              DaggerAppComponent.this.appModule));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final NewsDetailsActivitySubcomponentBuilder builder) {
      this.newsDetailsActivityModule = builder.newsDetailsActivityModule;
    }

    @Override
    public void inject(NewsDetailsActivity arg0) {
      injectNewsDetailsActivity(arg0);
    }

    private NewsDetailsActivity injectNewsDetailsActivity(NewsDetailsActivity instance) {
      NewsDetailsActivity_MembersInjector.injectMNewsDetailsViewModel(
          instance, getNewsDetailsViewModel());
      return instance;
    }
  }
}