package com.example.acedittextandwebview;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFB, btnGoogle, btnYT,btnSearch;
    WebView webView;
    String[] urls;
    AutoCompleteTextView autoCompleteTextView;
    String userURL;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFB=findViewById(R.id.fb);
        btnGoogle=findViewById(R.id.gg);
        btnYT=findViewById(R.id.yt);
        webView=findViewById(R.id.WV);
        autoCompleteTextView = findViewById(R.id.inputURL);
        btnSearch=findViewById(R.id.search);

        urls=getResources().getStringArray(R.array.urls);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>( this,android.R.layout.select_dialog_item,urls ));

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setJavaScriptEnabled(true);

        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.facebook.com");
                webView.setWebViewClient(new MyBrowser());
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com");
                webView.setWebViewClient(new MyBrowser());
            }
        });

        btnYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.youtube.com");
                webView.setWebViewClient(new MyBrowser());
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userURL=autoCompleteTextView.getText().toString();
                webView.loadUrl("https://"+userURL);
                webView.setWebViewClient(new MyBrowser());

            }
        });
    }

    public class MyBrowser extends WebViewClient{

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
