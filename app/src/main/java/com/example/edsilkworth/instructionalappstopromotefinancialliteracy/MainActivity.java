package com.example.edsilkworth.instructionalappstopromotefinancialliteracy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    ViewPager pager;
    FragmentManager fm;
    MyFragmentPagerAdapter pagerAdapter;
    SharedPreferences shared_preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        fm = getSupportFragmentManager();
        pagerAdapter = new MyFragmentPagerAdapter(fm);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                /**On page change, that particular page should be selected */
                pager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
        shared_preferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE); //name is optional, but be consistent
        shared_preferences.edit().putFloat("loaned", (float) 20000.0).apply();
        shared_preferences.edit().putFloat("interest", (float) 4.66 / 12 / 100 * 12 * 100).apply();
        int temp1 = (int) ((20000.0 * 4.66 / 12 / 100 + 0.01) * 100);
        double temp2 = (double) (temp1) / 100;
        shared_preferences.edit().putFloat("pay_monthly", (float) temp2).apply();
        shared_preferences.edit().putFloat("pay_monthly_reference", (float) temp2).apply();
        shared_preferences.edit().putString("minimum", "Minimum").apply(); //optional for users, but this will reset the label while testing
        shared_preferences.edit().putInt("position", 0).apply(); //for Android only, used for i_reference
    }
}
