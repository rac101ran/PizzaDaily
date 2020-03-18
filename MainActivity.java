package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private FirebaseUser current;
    private DatabaseReference refer;
    private FirebaseAuth mAuth;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.nav_home) {
                      Intent i=new Intent(MainActivity.this,Goodbmipizza.class);
                      startActivity(i);
                }
                  if(destination.getId()==R.id.nav_gallery) {
                       Intent i=new Intent(MainActivity.this,Specials.class);
                        startActivity(i);
                  }
                       if(destination.getId()==R.id.nav_slideshow) {
                             Intent i=new Intent(MainActivity.this,Recomm.class);
                             startActivity(i);

                       }


                       if(destination.getId()==R.id.nav_share) {
                                  Intent i=new Intent(Intent.ACTION_SEND);
                                  i.setType("text/plain");
                                  i.putExtra(Intent.EXTRA_SUBJECT,"The motto of creating pizza daily is to restrict as much fat as possible but keeping taste in mind.");
                                  i.putExtra(Intent.EXTRA_TEXT,"Download Pizza Daily "+
                                          "Helps to recommend a type of Pizza according to your physical health");
                                  startActivity(Intent.createChooser(i,"SHARE USING"));

                       }


                  if(destination.getId()==R.id.nav_send) {
                      Intent i=new Intent(MainActivity.this,Aboutceo.class);
                      startActivity(i);
                  }



            }
        });
     }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUserr = mAuth.getCurrentUser();
        if (currentUserr == null) {
            Intent i=new Intent(MainActivity.this,Requestpage.class);
            startActivity(i);
            finish();

        }
    }




    @Override
        public boolean onCreateOptionsMenu (Menu menu){

            getMenuInflater().inflate(R.menu.main, menu);

            return true;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settingdid:
                Intent i = new Intent(MainActivity.this, Settingsinmenu.class);
                startActivity(i);
                return true;

            case R.id.profileid:
                Intent i3=new Intent(MainActivity.this,Profilepge.class);
                startActivity(i3);
                return true;

            case R.id.logoutidd:
              mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent i2=new Intent(MainActivity.this,Requestpage.class);
                startActivity(i2);
                return true;

            default:
                return true;
        }
    }

    @Override
        public boolean onSupportNavigateUp () {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    }

