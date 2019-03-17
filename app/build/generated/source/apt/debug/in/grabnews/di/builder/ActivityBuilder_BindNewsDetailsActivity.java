package in.grabnews.di.builder;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import in.grabnews.views.webview.NewsDetailsActivity;
import in.grabnews.views.webview.NewsDetailsActivityModule;

@Module(
  subcomponents = ActivityBuilder_BindNewsDetailsActivity.NewsDetailsActivitySubcomponent.class
)
public abstract class ActivityBuilder_BindNewsDetailsActivity {
  private ActivityBuilder_BindNewsDetailsActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(NewsDetailsActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      NewsDetailsActivitySubcomponent.Builder builder);

  @Subcomponent(modules = NewsDetailsActivityModule.class)
  public interface NewsDetailsActivitySubcomponent extends AndroidInjector<NewsDetailsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NewsDetailsActivity> {}
  }
}
