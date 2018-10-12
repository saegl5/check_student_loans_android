package com.example.edsilkworth.instructionalappstopromotefinancialliteracy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private int PAGE_COUNT;

    /** Constructor of the class */
    MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        PAGE_COUNT = 2;
    }

    /** This method will be invoked when a page is requested to create */
    @Override
    public Fragment getItem(int arg0) {
        if (arg0 == 0) {
            return new MyMainPage();
        }
        else if (arg0 == 1) {
            return new ShowMath();
        }
        return null;
    }

    /** Returns the number of pages */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
