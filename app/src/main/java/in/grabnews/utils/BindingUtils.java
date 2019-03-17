package in.grabnews.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.grabnews.R;
import in.grabnews.data.model.NewsResponse;
import in.grabnews.data.model.db.NewsArticles;
import in.grabnews.views.homenews.NewsAdapter;


public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"bind:adapter"})
    public static void addLiveDataItems(RecyclerView recyclerView, ArrayList<NewsArticles> newsArticlesArrayList) {
        NewsAdapter adapter = (NewsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(newsArticlesArrayList);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).placeholder(R.drawable.ic_place_holder_news).into(imageView);
    }

}
