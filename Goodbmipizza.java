package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Goodbmipizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbmipizza);
        Toast.makeText(Goodbmipizza.this, "press return key for main menu", Toast.LENGTH_SHORT).show();
    }
    public void clickme(View view) {
        EditText hei = (EditText) findViewById(R.id.hid);
        EditText wei = (EditText) findViewById(R.id.wid);
        EditText hei2=(EditText)findViewById(R.id.h2id);
        TextView t = (TextView) findViewById(R.id.print);
        double weight = Double.parseDouble(wei.getText().toString());
        double height = 0.3048*Double.parseDouble(hei.getText().toString());
        double height2=0.0254*Double.parseDouble(hei2.getText().toString());
        double heightfinal=height+height2;
        double bmi;
        bmi = weight / (heightfinal* heightfinal);

          if(bmi>=12 && bmi<18) {
              Intent i = new Intent(Goodbmipizza.this, Lowbmi.class);
              startActivity(i);
          }
           else if (bmi >= 18 && bmi < 23) {
                Intent i=new Intent (Goodbmipizza.this,Neww.class);
                startActivity(i);
        }

           else if(bmi>=23 && bmi<30) {
                      Intent i2=new Intent(Goodbmipizza.this,Highbmi.class);
                      startActivity(i2);

        }

             else {

            t.setText("Out of bounds");
        }
    }
}
