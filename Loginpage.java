package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Loginpage extends AppCompatActivity {
Button button;
FirebaseAuth auth;
EditText emailtext;
EditText passwordtext;
TextView t;
ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        auth=FirebaseAuth.getInstance();
        emailtext=(EditText)findViewById(R.id.emailid);
        passwordtext=(EditText)findViewById(R.id.passid);
        button=(Button)findViewById(R.id.loginclickid);
        t=(TextView)findViewById(R.id.forgottext);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        bar.setVisibility(View.INVISIBLE);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Loginpage.this,Passwordreset.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtext.getText().toString();
                String password = passwordtext.getText().toString();
                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                    Toast.makeText(Loginpage.this,"Just a moment",Toast.LENGTH_SHORT).show();
                                 bar.setVisibility(View.VISIBLE);
                                    login_user(email,password);
                }
            }
        });
    }
     private void login_user(String emaill,String pass) {
        auth.signInWithEmailAndPassword(emaill,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                        Intent i=new Intent(Loginpage.this,MainActivity.class);
                        startActivity(i);

                }
                else {
                    Toast.makeText(Loginpage.this, "Enter credentials Again", Toast.LENGTH_SHORT).show();
                    SpannableString str=new SpannableString("Forgot Password ?");
                    UnderlineSpan s=new UnderlineSpan();
                    str.setSpan(s,0,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    t.setText(str);
                }
            }
        });

     }
}
