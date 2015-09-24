package de.heiligenlexikon.heiligenlexikon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://heiligenlexikon.de");
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                if (urlx.contains("heiligenlexikon.de")) {
                    viewx.loadUrl(urlx);
                } else {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlx));
                    startActivity(i);
                }
                return true;
            }
        });
        return;
    }
}
