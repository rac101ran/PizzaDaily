package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Highbmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highbmi);
    }

     public void click1(View view) {
         WebView w=new WebView(this);
         setContentView(w);
         w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/onion");

     }
    public void click2(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/capsicum");

    }
    public void click3(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/tomato");

    }
    public void click4(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/golden-corn");

    }

}
