// Generated by Dagger (https://google.github.io/dagger).
package in.grabnews.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.grabnews.data.AppDataManager;
import in.grabnews.data.DataManager;
import javax.inject.Provider;

public final class AppModule_ProvideDataManagerFactory implements Factory<DataManager> {
  private final AppModule module;

  private final Provider<AppDataManager> appDataManagerProvider;

  public AppModule_ProvideDataManagerFactory(
      AppModule module, Provider<AppDataManager> appDataManagerProvider) {
    this.module = module;
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public DataManager get() {
    return Preconditions.checkNotNull(
        module.provideDataManager(appDataManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideDataManagerFactory create(
      AppModule module, Provider<AppDataManager> appDataManagerProvider) {
    return new AppModule_ProvideDataManagerFactory(module, appDataManagerProvider);
  }

  public static DataManager proxyProvideDataManager(
      AppModule instance, AppDataManager appDataManager) {
    return Preconditions.checkNotNull(
        instance.provideDataManager(appDataManager),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
