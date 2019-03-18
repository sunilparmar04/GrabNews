
package android.databinding;
import in.grabnews.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case in.grabnews.R.layout.item_news:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/item_news_0".equals(tag)) {
                            return new in.grabnews.databinding.ItemNewsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for item_news is invalid. Received: " + tag);
                }
                case in.grabnews.R.layout.activity_web_view:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_web_view_0".equals(tag)) {
                            return new in.grabnews.databinding.ActivityWebViewBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_web_view is invalid. Received: " + tag);
                }
                case in.grabnews.R.layout.nav_header_main:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/nav_header_main_0".equals(tag)) {
                            return new in.grabnews.databinding.NavHeaderMainBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for nav_header_main is invalid. Received: " + tag);
                }
                case in.grabnews.R.layout.activity_home_news:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_home_news_0".equals(tag)) {
                            return new in.grabnews.databinding.ActivityHomeNewsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_home_news is invalid. Received: " + tag);
                }
                case in.grabnews.R.layout.activity_splash:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_splash_0".equals(tag)) {
                            return new in.grabnews.databinding.ActivitySplashBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -1455977205: {
                if(tag.equals("layout/item_news_0")) {
                    return in.grabnews.R.layout.item_news;
                }
                break;
            }
            case 697109804: {
                if(tag.equals("layout/activity_web_view_0")) {
                    return in.grabnews.R.layout.activity_web_view;
                }
                break;
            }
            case -477551781: {
                if(tag.equals("layout/nav_header_main_0")) {
                    return in.grabnews.R.layout.nav_header_main;
                }
                break;
            }
            case -274885191: {
                if(tag.equals("layout/activity_home_news_0")) {
                    return in.grabnews.R.layout.activity_home_news;
                }
                break;
            }
            case 1573928931: {
                if(tag.equals("layout/activity_splash_0")) {
                    return in.grabnews.R.layout.activity_splash;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"viewModel"};
    }
}