// Generated by Dagger (https://google.github.io/dagger).
package in.grabnews.views.webview;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.grabnews.data.DataManager;
import in.grabnews.utils.rx.SchedulerProvider;
import javax.inject.Provider;

public final class NewsDetailsActivityModule_ProvideSplashViewModelFactory
    implements Factory<NewsDetailsViewModel> {
  private final NewsDetailsActivityModule module;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  public NewsDetailsActivityModule_ProvideSplashViewModelFactory(
      NewsDetailsActivityModule module,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider) {
    this.module = module;
    this.dataManagerProvider = dataManagerProvider;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public NewsDetailsViewModel get() {
    return Preconditions.checkNotNull(
        module.provideSplashViewModel(dataManagerProvider.get(), schedulerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NewsDetailsActivityModule_ProvideSplashViewModelFactory create(
      NewsDetailsActivityModule module,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider) {
    return new NewsDetailsActivityModule_ProvideSplashViewModelFactory(
        module, dataManagerProvider, schedulerProvider);
  }

  public static NewsDetailsViewModel proxyProvideSplashViewModel(
      NewsDetailsActivityModule instance,
      DataManager dataManager,
      SchedulerProvider schedulerProvider) {
    return Preconditions.checkNotNull(
        instance.provideSplashViewModel(dataManager, schedulerProvider),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
