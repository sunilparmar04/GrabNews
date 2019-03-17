package in.grabnews.data.remote;

import in.grabnews.data.model.NewsRequest;
import in.grabnews.data.model.NewsResponse;
import io.reactivex.Single;

public interface ApiHelper {

    Single<NewsResponse> doGetNewsApiCall(NewsRequest.NewsParamsRequest request);

    ApiHeader getApiHeader();
}
