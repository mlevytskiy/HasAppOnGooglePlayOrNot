package hasappongoogleplayornot.mlevytskiy.com.hasappongoogleplayornot;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);
    }

    public void onClickSend(View view) {
        String packageName = editText.getText().toString();
        GooglePlayCheckerApi api = new GooglePlayCheckerApi.Builder().build();
        final long startTime = new Date().getTime();
        api.asyncCheck(packageName, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                long endTime = new Date().getTime();
                long delta = endTime - startTime;

                Toast.makeText(MainActivity.this, "ok delta=" + delta, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError retrofitError) {

                long endTime = new Date().getTime();
                long delta = endTime - startTime;

                String reason = retrofitError.getResponse().getReason();
                if (TextUtils.equals("Not Found", reason)) {
                    Toast.makeText(MainActivity.this, "Not Found delta=" + delta, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "delta=" + delta, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
