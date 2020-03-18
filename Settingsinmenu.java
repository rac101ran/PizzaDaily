package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Settingsinmenu extends AppCompatActivity {
FirebaseAuth auth;
FirebaseUser cur_user;
DatabaseReference refer;
EditText name;
EditText age;
EditText workouts;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsinmenu);
        auth=FirebaseAuth.getInstance();
        cur_user=FirebaseAuth.getInstance().getCurrentUser();
        String userid=cur_user.getUid();
        refer= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
        name=(EditText)findViewById(R.id.nameid);
        age=(EditText)findViewById(R.id.agetextview);
        workouts=(EditText)findViewById(R.id.workoutid);
        b=(Button)findViewById(R.id.saveid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee=name.getText().toString();
                String agee=age.getText().toString();
                String workoutss=workouts.getText().toString();
                if(!TextUtils.isEmpty(namee) || !TextUtils.isEmpty(agee) || !TextUtils.isEmpty(workoutss)) {
                    Map<String, String> m = new HashMap<>();
                    m.put("Full Name", namee);
                    m.put("Age", agee);
                    m.put("Workout per week", workoutss);
                    refer.setValue(m);
                    Toast.makeText(Settingsinmenu.this, "Data saved", Toast.LENGTH_LONG).show();
                }
                else {
                           Toast.makeText(Settingsinmenu.this,"Invalid Input",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
