package in.grabnews.views.homenews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import in.grabnews.AppController;
import in.grabnews.data.model.db.NewsArticles;
import in.grabnews.databinding.ItemNewsBinding;
import in.grabnews.views.base.BaseViewHolder;

public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<NewsArticles> newsList;

    @Inject
    Context mContext;

    public NewsAdapter(ArrayList<NewsArticles> newsList) {
        this.newsList = newsList;
    }


    public class LiveDataHolder extends BaseViewHolder implements NewsDataItemViewModel.LiveDataModelListener {
        ItemNewsBinding mBinding;
        NewsDataItemViewModel mLiveDataItemModel;

        public LiveDataHolder(ItemNewsBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        @Override
        public void onBind(int position) {
            NewsArticles liveDataResponse = newsList.get(position);
           // mLiveDataItemModel = new NewsDataItemViewModel(liveDataResponse.getTitle(), this);
            mLiveDataItemModel = new NewsDataItemViewModel(liveDataResponse, this);

            mBinding.setViewModel(mLiveDataItemModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();

        }

        @Override
        public void onItemClick(String name) {
            Log.v("click_item", "name:" + name);

            Toast.makeText(AppController.getInstace(), "name:" + name, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemNewsBinding liveDataViewBinding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new LiveDataHolder(liveDataViewBinding);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public void addItems(List<NewsArticles> newsArticlesList) {
        newsList.addAll(newsArticlesList);
        notifyDataSetChanged();
    }


    public void clearItems() {
        newsList.clear();
    }

}
