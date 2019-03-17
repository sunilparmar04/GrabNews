package in.grabnews.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.grabnews.views.homenews.HomeNewsActivity;
import in.grabnews.views.homenews.HomeNewsActivityModule;
import in.grabnews.views.webview.NewsDetailsActivity;
import in.grabnews.views.webview.NewsDetailsActivityModule;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = HomeNewsActivityModule.class)
    abstract HomeNewsActivity bindHomeNewsActivity();

    @ContributesAndroidInjector(modules = NewsDetailsActivityModule.class)
    abstract NewsDetailsActivity bindNewsDetailsActivity();

}
