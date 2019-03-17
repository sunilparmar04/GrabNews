// Generated by Dagger (https://google.github.io/dagger).
package in.grabnews.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideApiKeyFactory implements Factory<String> {
  private final AppModule module;

  public AppModule_ProvideApiKeyFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return Preconditions.checkNotNull(
        module.provideApiKey(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static AppModule_ProvideApiKeyFactory create(AppModule module) {
    return new AppModule_ProvideApiKeyFactory(module);
  }

  public static String proxyProvideApiKey(AppModule instance) {
    return Preconditions.checkNotNull(
        instance.provideApiKey(), "Cannot return null from a non-@Nullable @Provides method");
  }
}