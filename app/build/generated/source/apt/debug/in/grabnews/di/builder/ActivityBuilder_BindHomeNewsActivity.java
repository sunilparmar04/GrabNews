package in.grabnews.di.builder;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import in.grabnews.views.homenews.HomeNewsActivity;
import in.grabnews.views.homenews.HomeNewsActivityModule;

@Module(subcomponents = ActivityBuilder_BindHomeNewsActivity.HomeNewsActivitySubcomponent.class)
public abstract class ActivityBuilder_BindHomeNewsActivity {
  private ActivityBuilder_BindHomeNewsActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(HomeNewsActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      HomeNewsActivitySubcomponent.Builder builder);

  @Subcomponent(modules = HomeNewsActivityModule.class)
  public interface HomeNewsActivitySubcomponent extends AndroidInjector<HomeNewsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeNewsActivity> {}
  }
}
