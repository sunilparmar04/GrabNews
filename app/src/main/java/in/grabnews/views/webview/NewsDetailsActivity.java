package in.grabnews.views.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import javax.inject.Inject;

import in.grabnews.BR;
import in.grabnews.R;
import in.grabnews.databinding.ActivityWebViewBinding;
import in.grabnews.utils.AppConstants;
import in.grabnews.views.base.BaseActivity;

public class NewsDetailsActivity extends BaseActivity<ActivityWebViewBinding, NewsDetailsViewModel> implements NavigationView.OnNavigationItemSelectedListener {
    private WebView mWebview;
    private ProgressBar mProgressBar;


    @Inject
    NewsDetailsViewModel mNewsDetailsViewModel;

    ActivityWebViewBinding mActivityWebViewBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public NewsDetailsViewModel getViewModel() {
        return mNewsDetailsViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityWebViewBinding = getViewDataBinding();
        initViews();

    }

    private void initViews() {

        setSupportActionBar(mActivityWebViewBinding.toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = mActivityWebViewBinding.progressView;
        mWebview = mActivityWebViewBinding.webviewOffer;
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(AppConstants.NEWS_DETAILS_URL)) {
            String newsUrl = intent.getStringExtra(AppConstants.NEWS_DETAILS_URL);

            if (!TextUtils.isEmpty(newsUrl)) {
                renderWebPage(intent.getStringExtra(AppConstants.NEWS_DETAILS_URL));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    protected void renderWebPage(String urlToRender) {

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.bringToFront();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
            }

        });

        mWebview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);

                }
            }
        });

        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl(urlToRender);
    }

}
