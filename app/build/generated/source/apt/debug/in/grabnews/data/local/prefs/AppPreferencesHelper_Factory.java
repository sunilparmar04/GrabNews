// Generated by Dagger (https://google.github.io/dagger).
package in.grabnews.data.local.prefs;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AppPreferencesHelper_Factory implements Factory<AppPreferencesHelper> {
  private final Provider<Context> contextProvider;

  private final Provider<String> prefFileNameProvider;

  public AppPreferencesHelper_Factory(
      Provider<Context> contextProvider, Provider<String> prefFileNameProvider) {
    this.contextProvider = contextProvider;
    this.prefFileNameProvider = prefFileNameProvider;
  }

  @Override
  public AppPreferencesHelper get() {
    return new AppPreferencesHelper(contextProvider.get(), prefFileNameProvider.get());
  }

  public static AppPreferencesHelper_Factory create(
      Provider<Context> contextProvider, Provider<String> prefFileNameProvider) {
    return new AppPreferencesHelper_Factory(contextProvider, prefFileNameProvider);
  }
}