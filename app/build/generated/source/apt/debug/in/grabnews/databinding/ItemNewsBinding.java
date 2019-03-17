package in.grabnews.databinding;
import in.grabnews.R;
import in.grabnews.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemNewsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    public final android.widget.TextView authorTextView;
    @NonNull
    public final android.widget.TextView contentTextView;
    @NonNull
    public final android.widget.ImageView coverImageView;
    @NonNull
    public final android.widget.TextView dateTextView;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.support.v7.widget.CardView mboundView1;
    @NonNull
    public final android.widget.TextView titleTextView;
    // variables
    @Nullable
    private in.grabnews.views.homenews.NewsDataItemViewModel mViewModel;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemNewsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.authorTextView = (android.widget.TextView) bindings[4];
        this.authorTextView.setTag(null);
        this.contentTextView = (android.widget.TextView) bindings[5];
        this.contentTextView.setTag(null);
        this.coverImageView = (android.widget.ImageView) bindings[2];
        this.coverImageView.setTag(null);
        this.dateTextView = (android.widget.TextView) bindings[6];
        this.dateTextView.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.v7.widget.CardView) bindings[1];
        this.mboundView1.setTag(null);
        this.titleTextView = (android.widget.TextView) bindings[3];
        this.titleTextView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setViewModel((in.grabnews.views.homenews.NewsDataItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable in.grabnews.views.homenews.NewsDataItemViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    @Nullable
    public in.grabnews.views.homenews.NewsDataItemViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelAutherName((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelNewsArticlesField((android.databinding.ObservableField<in.grabnews.data.model.db.NewsArticles>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelAutherName(android.databinding.ObservableField<java.lang.String> ViewModelAutherName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelNewsArticlesField(android.databinding.ObservableField<in.grabnews.data.model.db.NewsArticles> ViewModelNewsArticlesField, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        java.lang.String viewModelNewsArticlesFieldGetGetTitle = null;
        java.lang.String viewModelAutherNameGet = null;
        java.lang.String viewModelNewsArticlesFieldGetGetContent = null;
        java.lang.String viewModelNewsArticlesFieldGetGetPublishedAt = null;
        android.databinding.ObservableField<java.lang.String> viewModelAutherName = null;
        java.lang.String viewModelNewsArticlesFieldGetGetUrlToImage = null;
        android.databinding.ObservableField<in.grabnews.data.model.db.NewsArticles> viewModelNewsArticlesField = null;
        in.grabnews.data.model.db.NewsArticles viewModelNewsArticlesFieldGet = null;
        in.grabnews.views.homenews.NewsDataItemViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.autherName
                        viewModelAutherName = viewModel.autherName;
                    }
                    updateRegistration(0, viewModelAutherName);


                    if (viewModelAutherName != null) {
                        // read viewModel.autherName.get()
                        viewModelAutherNameGet = viewModelAutherName.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.newsArticlesField
                        viewModelNewsArticlesField = viewModel.newsArticlesField;
                    }
                    updateRegistration(1, viewModelNewsArticlesField);


                    if (viewModelNewsArticlesField != null) {
                        // read viewModel.newsArticlesField.get()
                        viewModelNewsArticlesFieldGet = viewModelNewsArticlesField.get();
                    }


                    if (viewModelNewsArticlesFieldGet != null) {
                        // read viewModel.newsArticlesField.get().getTitle()
                        viewModelNewsArticlesFieldGetGetTitle = viewModelNewsArticlesFieldGet.getTitle();
                        // read viewModel.newsArticlesField.get().getContent()
                        viewModelNewsArticlesFieldGetGetContent = viewModelNewsArticlesFieldGet.getContent();
                        // read viewModel.newsArticlesField.get().getPublishedAt()
                        viewModelNewsArticlesFieldGetGetPublishedAt = viewModelNewsArticlesFieldGet.getPublishedAt();
                        // read viewModel.newsArticlesField.get().getUrlToImage()
                        viewModelNewsArticlesFieldGetGetUrlToImage = viewModelNewsArticlesFieldGet.getUrlToImage();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.authorTextView, viewModelAutherNameGet);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.contentTextView, viewModelNewsArticlesFieldGetGetContent);
            in.grabnews.utils.BindingUtils.setImageUrl(this.coverImageView, viewModelNewsArticlesFieldGetGetUrlToImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.dateTextView, viewModelNewsArticlesFieldGetGetPublishedAt);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.titleTextView, viewModelNewsArticlesFieldGetGetTitle);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        in.grabnews.views.homenews.NewsDataItemViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onItemClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemNewsBinding>inflate(inflater, in.grabnews.R.layout.item_news, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemNewsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemNewsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(in.grabnews.R.layout.item_news, null, false), bindingComponent);
    }
    @NonNull
    public static ItemNewsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemNewsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_news_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemNewsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.autherName
        flag 1 (0x2L): viewModel.newsArticlesField
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}