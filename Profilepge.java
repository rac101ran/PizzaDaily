package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profilepge extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser curr_user;
    DatabaseReference ref;
    TextView nametext;
    TextView agetext;
    TextView worktext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepge);
        auth=FirebaseAuth.getInstance();
        curr_user=FirebaseAuth.getInstance().getCurrentUser();
        String userid=curr_user.getUid();
        ref= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
        nametext=(TextView)findViewById(R.id.nametextview);
        agetext=(TextView)findViewById(R.id.agetextview);
        worktext=(TextView)findViewById(R.id.workouttextview);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nametext.setText("Name:   "+dataSnapshot.child("Full Name").getValue().toString());
                agetext.setText("Age:   "+dataSnapshot.child("Age").getValue().toString());
                worktext.setText("Workout per week:   "+dataSnapshot.child("Workout per week").getValue().toString());
                Toast.makeText(Profilepge.this,"Welcome "+dataSnapshot.child("Full Name").getValue().toString(),Toast.LENGTH_SHORT).show();
                double d=Double.parseDouble(dataSnapshot.child("Workout per week").getValue().toString());
                 if(d<4) {
                     Toast.makeText(Profilepge.this,"Consume pizza not more than twice a week",Toast.LENGTH_LONG).show();
                 }
                 else if(d>4 && d<7) {
                      Toast.makeText(Profilepge.this,"You can consume pizza five times a week",Toast.LENGTH_LONG).show();
                 }
                     else if(d>7){
                              Toast.makeText(Profilepge.this,"Invalid Workout Input",Toast.LENGTH_LONG).show();
                 }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
