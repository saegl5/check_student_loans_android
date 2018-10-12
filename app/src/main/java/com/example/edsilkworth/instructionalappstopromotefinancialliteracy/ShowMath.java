package com.example.edsilkworth.instructionalappstopromotefinancialliteracy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowMath extends Fragment {

    TextView loaned;
    TextView nominal_rate;
    TextView periodic_rate;
    TextView decimal_equivalent;
    TextView pay_monthly;
    TextView remaining_balance; //for font only
    TextView month1;
    TextView month2;
    TextView month3;
    TextView keep_going; //for font only
    TextView monthmax;
    TextView est_time; //for font only
    TextView years;
    TextView months;
    TextView est_savings; //for font only
    TextView total_paid;
    TextView savings;
    Typeface myTypeface; //for Android only
    //no need for number formatter
    SharedPreferences shared_preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.showmath_layout, container, false);
        /**below are for Android only*/
        loaned = (TextView) v.findViewById(R.id.textView14);
        nominal_rate = (TextView) v.findViewById(R.id.textView15);
        periodic_rate = (TextView) v.findViewById(R.id.textView16);
        decimal_equivalent = (TextView) v.findViewById(R.id.textView17);
        pay_monthly = (TextView) v.findViewById(R.id.textView18);
        remaining_balance = (TextView) v.findViewById(R.id.textView19);
        month1 = (TextView) v.findViewById(R.id.textView20);
        month2 = (TextView) v.findViewById(R.id.textView21);
        month3 = (TextView) v.findViewById(R.id.textView22);
        keep_going = (TextView) v.findViewById(R.id.textView23);
        monthmax = (TextView) v.findViewById(R.id.textView24);
        est_time = (TextView) v.findViewById(R.id.textView25);
        years = (TextView) v.findViewById(R.id.textView26);
        months = (TextView) v.findViewById(R.id.textView27);
        est_savings = (TextView) v.findViewById(R.id.textView28);
        total_paid = (TextView) v.findViewById(R.id.textView29);
        savings = (TextView) v.findViewById(R.id.textView30);
        myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "cmunrm.ttf");
        loaned.setTypeface(myTypeface);
        nominal_rate.setTypeface(myTypeface);
        periodic_rate.setTypeface(myTypeface);
        decimal_equivalent.setTypeface(myTypeface);
        pay_monthly.setTypeface(myTypeface);
        remaining_balance.setTypeface(myTypeface);
        month1.setTypeface(myTypeface);
        month2.setTypeface(myTypeface);
        month3.setTypeface(myTypeface);
        keep_going.setTypeface(myTypeface);
        monthmax.setTypeface(myTypeface);
        est_time.setTypeface(myTypeface);
        years.setTypeface(myTypeface);
        months.setTypeface(myTypeface);
        est_savings.setTypeface(myTypeface);
        total_paid.setTypeface(myTypeface);
        savings.setTypeface(myTypeface);
        shared_preferences = v.getContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE); //name is optional, but be consistent
        /**--------------------------*/
        double p = (double) shared_preferences.getFloat("loaned", 0);
        double i = (double) shared_preferences.getFloat("interest", 0);
        double a = (double) shared_preferences.getFloat("pay_monthly", 0);
        /**Android only, to correct for loss in precision--------------------*/
        int i_correction = ((int) (Math.round(i * 100)));
        i = (double) (i_correction) / 100;
        int a_correction1 = ((int) (Math.round(a * 100)));
        a = (double) (a_correction1) / 100;
        /**------------------------------------------------------------------*/
        i = i / 12 / 100; //need to convert to periodic rate in decimal form

        //please cross-check these with strings.xml
        loaned.setText(getString(R.string.loaned_string, p));
        nominal_rate.setText(getString(R.string.apr_string, i * 100 * 12, "%"));
        periodic_rate.setText(getString(R.string.div12, i * 100, "% monthly"));
        decimal_equivalent.setText(getString(R.string.div100, i, "monthly"));
        pay_monthly.setText(getString(R.string.pay, a, " monthly"));

        month1.setText(getString(R.string.month_string, p, p, i, a, p + (double) ((int) (p * i * 100)) / 100 - a));

        double temp1 = p + (double)((int)(p * i * 100)) / 100 - a;
        month2.setText(getString(R.string.month_string, temp1, temp1, i, a, temp1 + (double)((int)(temp1 * i * 100)) / 100 - a));

        double temp2 = temp1 + (double)((int)(temp1 * i * 100)) / 100 - a;
        month3.setText(getString(R.string.month_string, temp2, temp2, i, a, temp2 + (double) ((int) (temp2 * i * 100)) / 100 - a));

        int j = 0; //defined here in order to simplify the rest
        double remainingbalance = p; //defined here in order to simplify the rest too
        if (i != 0) {
            while (remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100 > a) {
                remainingbalance = remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100 - a;
                j += 1;
            }
        }
        else {
            j = (int)(Math.ceil((p / a) - 1));
            remainingbalance = p - a * (double)(j);
        }
        monthmax.setText(getString(R.string.month_string, remainingbalance, remainingbalance, i, remainingbalance + (double) ((int) (remainingbalance * i * 100)) / 100, 0.00));

        int temp3 = (int)(Math.floor((double) ((j + 1) / 12)));
        years.setText(getString(R.string.years_string, j + 1, temp3, "year(s)"));
        months.setText(getString(R.string.months_string, j + 1, temp3, (j + 1) - temp3 * 12, "month(s)"));

        total_paid.setText(getString(R.string.total_string, j, a, remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100, (double)(j) * a + remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100, "total paid"));

        int k = 0;
        double remainingbalance_repay_minimum = p;
        if (i != 0) {
            while (remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100 > (double)((int)((p * i + 0.01) * 100)) / 100) {
                remainingbalance_repay_minimum = remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100 - (double)((int)((p * i + 0.01) * 100)) / 100;
                k += 1;
            }
        }
        else {
            k = (int)(p / 0.01 - 1);
            remainingbalance_repay_minimum = 0.01;
        }
        double total_repay_minimum_fromloop = (double)(k) * (double)((int)((p * i + 0.01) * 100)) / 100;        double total_repay_minimum_finalmonth = remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100;                                         double total_repay_minimum = total_repay_minimum_fromloop + total_repay_minimum_finalmonth;
        double total = (double)(j) * a + remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100;
        double saved = total_repay_minimum - total;
        if (saved < 0) {
            savings.setText(getString(R.string.savings_string, total_repay_minimum, total, (double)(0), "save"));
        }
        else {
            savings.setText(getString(R.string.savings_string, total_repay_minimum, total, saved, "save"));
        }

        return v;
    }

}
