package com.example.grajmane.medico;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);




        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_bar);
        //BottomNavigationViewHelper
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.home:
                        Intent intent=new Intent(Account.this,Main2Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.recent:


                        break;
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent in=new Intent(Account.this,MainActivity.class);
                        startActivity(in);
                        break;

                }
                return false;
            }
        });
    }
}
