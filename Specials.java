package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

public class Specials extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);


    }

    public void click1(View view) {



            WebView w = new WebView(this);
            setContentView(w);
            w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/indi-tandoori-paneer");
        }


    public void click2(View view) {

        WebView w = new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/non-veg-pizzas/indi-chicken-tikka");
    }

    public void click3(View view) {

        WebView w = new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/non-veg-loaded");
    }

    public void click4(View view) {

        WebView w = new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/pizza-mania/veg-loaded");
    }

    public void click5(View view) {

        WebView w = new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/non-veg-pizzas/non-veg-supreme");
    }

    public void click6(View view) {

        WebView w = new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/menu/veg-pizzas/veggie-paradise");
    }




    public void settime(String timee) {
        TextView t = (TextView) findViewById(R.id.time);
        t.setText(timee);
    }
}

