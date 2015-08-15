package hasappongoogleplayornot.mlevytskiy.com.hasappongoogleplayornot;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;

/**
 * Created by max on 14.06.15.
 */
public abstract class AnyApiBuilder<T> {

    private static final int TIMEOUT = 20;

    public abstract T build();

//    protected T build(Class<T> api) {
//        return build(api, ServerUri.MAIN_SERVER_URI);
//    }

    protected T build(Class<T> api, String uri) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);

        return new RestAdapter.Builder()
                .setEndpoint(uri)
//                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(api);
    }


}
