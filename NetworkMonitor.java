import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class NetworkMonitor {

    public void monitorNetworkRequest() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://example.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.error("Network request failed", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    AlertManager.notify("Network request unsuccessful: " + response);
                } else {
                    Logger.debug("Network request successful: " + response);
                    // Analyze response for suspicious activity
                    BehaviorAnalyzer.analyze(response);
                }
            }
        });
    }
}
