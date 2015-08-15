package hasappongoogleplayornot.mlevytskiy.com.hasappongoogleplayornot;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.HEAD;
import retrofit.http.Query;

/**
 * Created by max on 15.08.15.
 */
public interface GooglePlayCheckerApi {

    String URL = "https://play.google.com/";

    @HEAD("/store/apps/details")
    Response syncCheck(@Query("id") String packageName);

    @HEAD("/store/apps/details")
    void asyncCheck(@Query("id") String packageName, Callback<Response> callback);

    class Builder extends AnyApiBuilder<GooglePlayCheckerApi> {

        @Override
        public GooglePlayCheckerApi build() {
            return build(GooglePlayCheckerApi.class, URL);
        }

    }
}
