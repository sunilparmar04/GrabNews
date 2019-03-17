package in.grabnews.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.grabnews.data.model.NewsRequest;
import in.grabnews.data.model.NewsResponse;
import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }


    @Override
    public Single<NewsResponse> doGetNewsApiCall(NewsRequest.NewsParamsRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_NEWS)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addQueryParameter(request)
                .build()
                .getObjectSingle(NewsResponse.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
