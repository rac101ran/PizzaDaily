package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Recomm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomm);
    }
    public void dominosclick(View view) {
        WebView w=new WebView(this);
        setContentView(w);
        w.loadUrl("https://www.dominos.co.in/");
    }
     public void ovenstoryclick(View view) {
         WebView w=new WebView(this);
         setContentView(w);
         w.loadUrl("https://www.google.com/search?rlz=1C1CHBF_enIN879IN879&sxsrf=ACYBGNSpjGqbjiZaEXs47plh3IOqA8eP7g%3A1577207838324&ei=HkgCXv3AE7SR4-EPgI2f8Ac&q=ovenstory+&oq=ovenstory+&gs_l=psy-ab.3..0l10.4910.8677..9368...2.1..0.260.2197.0j1j9......0....1..gws-wiz.....10..0i71j35i39j0i273j0i67j0i131j35i362i39.o3ts71UeJwg&ved=0ahUKEwj9x8KH5c7mAhW0yDgGHYDGB34Q4dUDCAs&uact=5");
  }
}
