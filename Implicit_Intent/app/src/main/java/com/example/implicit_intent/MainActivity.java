package com.example.implicit_intent;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView displayNumber;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnStar,btnHash,btnDial,btnClear,btnMaps,btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNumber=findViewById(R.id.showNumber);
        btn1=findViewById(R.id.one);
        btn2=findViewById(R.id.two);
        btn3=findViewById(R.id.three);
        btn4=findViewById(R.id.four);
        btn5=findViewById(R.id.five);
        btn6=findViewById(R.id.six);
        btn7=findViewById(R.id.seven);
        btn8=findViewById(R.id.eight);
        btn9=findViewById(R.id.nine);
        btn0=findViewById(R.id.zero);
        btnStar=findViewById(R.id.star);
        btnHash=findViewById(R.id.hash);
        btnDial=findViewById(R.id.dial);
        btnClear=findViewById(R.id.clear);
        btnMaps=findViewById(R.id.maps);
        btnClose=findViewById(R.id.close);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnHash.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnMaps.setOnClickListener(this);
        btnClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.one:
                displayNumber.append("1");
                break;

            case R.id.two:
                displayNumber.append("2");
                break;

            case R.id.three:
                displayNumber.append("3");
                break;

            case R.id.four:
                displayNumber.append("4");
                break;

            case R.id.five:
                displayNumber.append("5");
                break;

            case R.id.six:
                displayNumber.append("6");
                break;

            case R.id.seven:
                displayNumber.append("7");
                break;

            case R.id.eight:
                displayNumber.append("8");
                break;

            case R.id.nine:
                displayNumber.append("9");
                break;

            case R.id.zero:
                displayNumber.append("0");
                break;

            case R.id.star:
                displayNumber.append("*");
                break;

            case R.id.hash:
                displayNumber.append("#");
                break;

            case R.id.dial:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+displayNumber.getText()));
                startActivity(intent);
                break;

            case R.id.clear:
                String string=displayNumber.getText().toString();
                if(string.length()>1)
                {
                    string=string.substring(0,string.length()-1);
                    displayNumber.setText(string);
                }
                else if(string.length()<=1)
                {
                    displayNumber.setText("");
                }
                break;

            case R.id.maps:
               /* Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);*/

               final ProgressDialog progressDialog=new ProgressDialog(this);
               progressDialog.setTitle("Maps");
               progressDialog.setMessage("Please Wait");
               progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
               progressDialog.setCanceledOnTouchOutside(true);
               progressDialog.show();
               progressDialog.setCancelable(true);
               break;

            case R.id.close:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("Do you really want to close?")
                        .setTitle("DIALER").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
        }
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    public void showAlertDialog()
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Do you really want to close?")
                    .setTitle("DIALER").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.finish();
                }
            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.show();
        }
}
