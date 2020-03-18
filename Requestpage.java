package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Requestpage extends AppCompatActivity {
Animation anim,anim2;

Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestpage);
        b=(Button)findViewById(R.id.button2);
        b1=(Button)findViewById(R.id.loginclickid);

        anim= AnimationUtils.loadAnimation(this,R.anim.animae);
        b.setAnimation(anim);
        anim2=AnimationUtils.loadAnimation(this,R.anim.animae);

                b1.setAnimation(anim2);



    }
    public void signup(View view) {
        Intent i=new Intent(Requestpage.this,Registerpage.class);
        startActivity(i);
    }
    public void login(View view) {
       Intent i=new Intent(Requestpage.this,Loginpage.class);
       startActivity(i);
    }
}
