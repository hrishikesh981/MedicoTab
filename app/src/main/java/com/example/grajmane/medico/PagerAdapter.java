package com.example.grajmane.medico;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int no_of_tabs;

    public PagerAdapter(FragmentManager fm,int noTabs) {


        super(fm);
        this.no_of_tabs=noTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {

            case 0:
                Home home=new Home();
                return home;
            case 1:

                SearchMed searchMed=new SearchMed();
                return searchMed;
            case 2:
                SearchPharm searchPharm=new SearchPharm();
                return searchPharm;
            default:
                return null;

        }



    }

    @Override
    public int getCount() {
        return no_of_tabs;
    }
}
