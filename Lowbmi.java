package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Lowbmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowbmi);
    }
    public void vegclick(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/veg-extravaganza");
    }
    public void margeritaclick(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/margherita");
    }
    public void  deluxeclick(View view) {
        WebView w=new WebView (this);
          setContentView(w);
          w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/deluxe-veggie");
    }
}
