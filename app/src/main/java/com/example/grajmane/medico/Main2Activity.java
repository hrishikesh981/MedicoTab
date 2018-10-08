package com.example.grajmane.medico;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements Home.OnFragmentInteractionListener,SearchPharm.OnFragmentInteractionListener,SearchMed.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tableLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Medicine"));
        tabLayout.addTab(tabLayout.newTab().setText("Pharmacies"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        final PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_bar);
        //BottomNavigationViewHelper
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.home:

                        break;
                    case R.id.recent:
                        Intent intent=new Intent(Main2Activity.this,Account.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent in=new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(in);
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
