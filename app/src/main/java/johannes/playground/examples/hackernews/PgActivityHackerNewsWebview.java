package johannes.playground.examples.hackernews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 22.11.16.
 */
public class PgActivityHackerNewsWebview extends PgActivity {

    WebView mWebView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_hacker_news_webview);

        String articleUrl = getIntent().getExtras().getString(PgActivityHackerNews.ITEM_URL_KEY);

        mWebView = (WebView) findViewById(R.id.webViewHackerNews);

        mWebView.getSettings().setJavaScriptEnabled(false);

        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl(articleUrl);

    }
}
