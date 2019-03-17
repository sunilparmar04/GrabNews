package in.grabnews.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import in.grabnews.data.model.db.NewsArticles;

public class NewsResponse {

    @Expose
    @SerializedName("status")
    private String statusCode;

    @Expose
    @SerializedName("totalResults")
    private int totalResults;

    private ArrayList<NewsArticles> articles;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsArticles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsArticles> articles) {
        this.articles = articles;
    }

}
