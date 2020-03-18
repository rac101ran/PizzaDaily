package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Neww extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neww);
    }
    public void clickfarmhouse(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/farm-house");

    }
    public void doublecheeseclick(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/double-cheese-margherita");
    }
    public void dominatorclick(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/non-veg-pizzas/chicken-dominator");
    }
}
