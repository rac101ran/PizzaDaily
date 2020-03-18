package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Passwordreset extends AppCompatActivity {
FirebaseAuth auth;
TextView email;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordreset);
        auth=FirebaseAuth.getInstance();
        email=(TextView)findViewById(R.id.emailid);

        b=(Button)findViewById(R.id.sendid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaiL=email.getText().toString().trim();
                if(emaiL.equals(" ")) {
                        Toast.makeText(Passwordreset.this,"Enter email to reset",Toast.LENGTH_LONG).show();
                }
                else{
                    auth.sendPasswordResetEmail(emaiL).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Passwordreset.this, "EMAIL RESET LINK SENT TO YOUR EMAIL", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(Passwordreset.this, MainActivity.class));
                            } else {
                                Toast.makeText(Passwordreset.this,"enter email again",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

                }



            });
    }

}
