package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registerpage extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText name;
    EditText email;
    EditText pass;
    Button button;
    FirebaseUser user;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_registerpage);
        mAuth=FirebaseAuth.getInstance();

        email=(EditText)findViewById(R.id.emailid);
        button=(Button)findViewById(R.id.signup);
        pass=(EditText)findViewById(R.id.passwordid);
        name=(EditText)findViewById(R.id.nameid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee = name.getText().toString();
                String emaill = email.getText().toString();
                String passs = pass.getText().toString();
                if (!TextUtils.isEmpty(namee) || !TextUtils.isEmpty(emaill) || !TextUtils.isEmpty(passs)) {
                    Toast.makeText(Registerpage.this,"Just a Moment",Toast.LENGTH_LONG).show();
                    reg(namee, emaill, passs);
                }

            }
        });
    }



    public void reg(final String name,String email,String pass) {

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    user=FirebaseAuth.getInstance().getCurrentUser();
                    String userid=user.getUid();
                    ref= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
                    HashMap<String,String> map=new HashMap<>();
                    map.put("Name",name);
                    ref.setValue(map);
                    Intent i = new Intent(Registerpage.this, MainActivity.class);
                    startActivity(i);

                }
                else {

                    Toast.makeText(Registerpage.this, "Wrong Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

