package com.example.taxcalculator;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText salary;
    TextView taxDisplay;
    Button btnTaxCalculate;
    Float taxCalculate, taxAmount;
    UserSalary userSalary=new UserSalary();
    AutoCompleteTextView autoCompleteTextView;
    String[] countries;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.ACeditText);
        salary=findViewById(R.id.inputSalary);
        taxDisplay=findViewById(R.id.displayTax);
        btnTaxCalculate=findViewById(R.id.calculateTax);

        countries=getResources().getStringArray(R.array.countries);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,countries));

        webView=findViewById(R.id.webView);
        webView.loadUrl("htpps://lms.softwarica.edu.np");
        webView.setWebViewClient(new MyBrowser());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        btnTaxCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userSalary.setUserSalary(salary.getText().toString());
                taxCalculate=Float.parseFloat(salary.getText().toString());
                taxCalculate=taxCalculate*12;
                if(taxCalculate<=200000)
                {
                    taxAmount=(taxCalculate)/100;
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }
                else if(taxCalculate>200000 && taxCalculate<=350000)
                {
                    taxCalculate=taxCalculate-200000;
                    taxAmount=2000+((taxCalculate*15)/100);
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }
                else if(taxCalculate>350000)
                {
                    taxCalculate=taxCalculate-350000;
                    taxAmount=24500+((taxCalculate*25)/100);
                    taxDisplay.setText("Your yearly tax amount is Rs." +taxAmount.toString());
                }

            }
        });


    }

    public class MyBrowser extends WebViewClient{

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
