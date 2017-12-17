package johannes.playground.views.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 22.11.16.
 */
public class PgActivityWebview extends PgActivity {

    private WebView mWebView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_webview);

        mWebView = (WebView) findViewById(R.id.webView);

        // Disable JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Set new webclient
        mWebView.setWebViewClient(new WebViewClient());

        // Load Url
        mWebView.loadUrl("http://test.bionote.xyz");

        // Build html string
        String html = "<html><body><h1>Hi there!</h1><p>This is my website.</p></body></html>";

        // Load html from data
        // mWebView.loadData(html, "text/html", "UTF-8");

    }
}
