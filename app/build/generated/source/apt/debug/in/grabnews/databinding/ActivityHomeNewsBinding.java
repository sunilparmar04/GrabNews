package in.grabnews.databinding;
import in.grabnews.R;
import in.grabnews.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityHomeNewsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.drawerView, 6);
        sViewsWithIds.put(R.id.clRootView, 7);
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.navigationView, 9);
    }
    // views
    @NonNull
    public final android.widget.TextView categoryTextView;
    @NonNull
    public final android.support.design.widget.CoordinatorLayout clRootView;
    @NonNull
    public final android.widget.TextView countryTextView;
    @NonNull
    public final android.support.v4.widget.DrawerLayout drawerView;
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    public final android.support.design.widget.NavigationView navigationView;
    @NonNull
    public final android.support.v7.widget.RecyclerView newsRecyclerView;
    @NonNull
    public final android.support.v4.widget.ContentLoadingProgressBar progressContentLoadingProgressBar;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    @NonNull
    public final android.widget.TextView tvAppVersion;
    // variables
    @Nullable
    private in.grabnews.views.homenews.HomeNewsViewModel mViewModel;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityHomeNewsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 5);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.categoryTextView = (android.widget.TextView) bindings[2];
        this.categoryTextView.setTag(null);
        this.clRootView = (android.support.design.widget.CoordinatorLayout) bindings[7];
        this.countryTextView = (android.widget.TextView) bindings[1];
        this.countryTextView.setTag(null);
        this.drawerView = (android.support.v4.widget.DrawerLayout) bindings[6];
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.navigationView = (android.support.design.widget.NavigationView) bindings[9];
        this.newsRecyclerView = (android.support.v7.widget.RecyclerView) bindings[3];
        this.newsRecyclerView.setTag(null);
        this.progressContentLoadingProgressBar = (android.support.v4.widget.ContentLoadingProgressBar) bindings[5];
        this.progressContentLoadingProgressBar.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[8];
        this.tvAppVersion = (android.widget.TextView) bindings[4];
        this.tvAppVersion.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((in.grabnews.views.homenews.HomeNewsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable in.grabnews.views.homenews.HomeNewsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    @Nullable
    public in.grabnews.views.homenews.HomeNewsViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCountryCode((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelNewsCategory((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelAppVersion((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 4 :
                return onChangeViewModelLiveNewsObservableArrayList((android.databinding.ObservableArrayList<in.grabnews.data.model.db.NewsArticles>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCountryCode(android.databinding.ObservableField<java.lang.String> ViewModelCountryCode, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelNewsCategory(android.databinding.ObservableField<java.lang.String> ViewModelNewsCategory, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelAppVersion(android.databinding.ObservableField<java.lang.String> ViewModelAppVersion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(android.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelLiveNewsObservableArrayList(android.databinding.ObservableArrayList<in.grabnews.data.model.db.NewsArticles> ViewModelLiveNewsObservableArrayList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelAppVersionGet = null;
        android.databinding.ObservableField<java.lang.String> viewModelCountryCode = null;
        boolean viewModelIsLoadingGet = false;
        java.lang.String viewModelCountryCodeGet = null;
        java.lang.String viewModelNewsCategoryGet = null;
        android.databinding.ObservableField<java.lang.String> viewModelNewsCategory = null;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        android.databinding.ObservableField<java.lang.String> viewModelAppVersion = null;
        android.databinding.ObservableBoolean viewModelIsLoading = null;
        android.databinding.ObservableArrayList<in.grabnews.data.model.db.NewsArticles> viewModelLiveNewsObservableArrayList = null;
        in.grabnews.views.homenews.HomeNewsViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.countryCode
                        viewModelCountryCode = viewModel.getCountryCode();
                    }
                    updateRegistration(0, viewModelCountryCode);


                    if (viewModelCountryCode != null) {
                        // read viewModel.countryCode.get()
                        viewModelCountryCodeGet = viewModelCountryCode.get();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.newsCategory
                        viewModelNewsCategory = viewModel.getNewsCategory();
                    }
                    updateRegistration(1, viewModelNewsCategory);


                    if (viewModelNewsCategory != null) {
                        // read viewModel.newsCategory.get()
                        viewModelNewsCategoryGet = viewModelNewsCategory.get();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.appVersion
                        viewModelAppVersion = viewModel.getAppVersion();
                    }
                    updateRegistration(2, viewModelAppVersion);


                    if (viewModelAppVersion != null) {
                        // read viewModel.appVersion.get()
                        viewModelAppVersionGet = viewModelAppVersion.get();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isLoading
                        viewModelIsLoading = viewModel.getIsLoading();
                    }
                    updateRegistration(3, viewModelIsLoading);


                    if (viewModelIsLoading != null) {
                        // read viewModel.isLoading.get()
                        viewModelIsLoadingGet = viewModelIsLoading.get();
                    }
                if((dirtyFlags & 0x68L) != 0) {
                    if(viewModelIsLoadingGet) {
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                    }
                }


                    // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                    viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.liveNewsObservableArrayList
                        viewModelLiveNewsObservableArrayList = viewModel.liveNewsObservableArrayList;
                    }
                    updateRegistration(4, viewModelLiveNewsObservableArrayList);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.categoryTextView.setOnClickListener(mCallback3);
            this.countryTextView.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.categoryTextView, viewModelNewsCategoryGet);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.countryTextView, viewModelCountryCodeGet);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            in.grabnews.utils.BindingUtils.addLiveDataItems(this.newsRecyclerView, viewModelLiveNewsObservableArrayList);
        }
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            this.progressContentLoadingProgressBar.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvAppVersion, viewModelAppVersionGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // viewModel
                in.grabnews.views.homenews.HomeNewsViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onSelectCountry();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // viewModel
                in.grabnews.views.homenews.HomeNewsViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onSelectCategory();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityHomeNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityHomeNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityHomeNewsBinding>inflate(inflater, in.grabnews.R.layout.activity_home_news, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityHomeNewsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityHomeNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(in.grabnews.R.layout.activity_home_news, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityHomeNewsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityHomeNewsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_home_news_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityHomeNewsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.countryCode
        flag 1 (0x2L): viewModel.newsCategory
        flag 2 (0x3L): viewModel.appVersion
        flag 3 (0x4L): viewModel.isLoading
        flag 4 (0x5L): viewModel.liveNewsObservableArrayList
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
        flag 7 (0x8L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}