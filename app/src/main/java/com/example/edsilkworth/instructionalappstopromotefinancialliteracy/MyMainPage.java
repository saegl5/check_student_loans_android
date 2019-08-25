package com.example.edsilkworth.instructionalappstopromotefinancialliteracy;
import java.util.Locale;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView; //test

public class MyMainPage extends Fragment { //no need to call any list view delegate or data source

    SeekBar loaned;
    Switch apr;
    Button interest_rate;
    ImageButton arrow_unpressed;
    ImageButton arrow_pressed;
    ListView list_view;
    ImageButton down_unpressed;
    ImageButton down_pressed;
    TextView pay_monthly_title;
    TextView pay_monthly_box;
    ImageButton up_unpressed;
    ImageButton up_pressed;
    TextView minimum;
    TextView years;
    TextView months;
    TextView savings;
    double p; //initialized in onCreateView()
    double i; //initialized in onCreateView()
    double i_reference; //initialized in onCreateView()
    double a; //initialized in onCreateView()
    double a_reference; //for Android only, initialized in onCreateView()
    //no need for number formatter
    SharedPreferences shared_preferences;
    String rates[] = {"4.66% - Direct Loan","5% - Perkins Loan"};
    ArrayAdapter<String> rates_adapter; //used for placing rates[] into list view
    double rates_reference[] = {4.66 / 12 / 100, 5.00 / 12 / 100};
    Handler handler1;
    Handler handler2;

    /**instructions for slider*/
    public void Seekbar() {
        loaned.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seek) {
            } //empty but still required

            @Override
            public void onStartTrackingTouch(SeekBar seek) {
            }

            @Override
            public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {
                if (fromUser) {
                    //movement of seekbar set in mymainpage_layout.xml
                    progress = 2500 * progress + 20000;
                    p = (double) progress;
                    if (apr.isChecked()) {
                        int temp = (int) ((p * i + 0.01) * 100);
                        a = (double) (temp) / 100;
                    } else {
                        a = 0.01;
                    }
                    Lengthsaving();
                    shared_preferences.edit().putFloat("loaned", (float) p).apply(); //cannot putDouble
                    shared_preferences.edit().putFloat("pay_monthly", (float) a).apply();
                    pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
                    a_reference = a; //again, for Android only
                    shared_preferences.edit().putFloat("pay_monthly_reference", (float) a_reference).apply();
                    minimum.setVisibility(View.VISIBLE);
                    shared_preferences.edit().putString("minimum", "Minimum").apply();
                    minimum.setText(getString(R.string.minimum));
                }
            }
        });
    }

    /**instructions for switch*/
    public void Switch() {
        apr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    i = i_reference;
                    int temp = (int) ((p * i + 0.01) * 100);
                    a = (double) (temp) / 100;
                    interest_rate.setVisibility(View.VISIBLE);
                    arrow_unpressed.setVisibility(View.VISIBLE);
                } else {
                    i_reference = rates_reference[shared_preferences.getInt("position", 0)];
                    i = 0;
                    a = 0.01;
                    interest_rate.setVisibility(View.INVISIBLE);
                    arrow_unpressed.setVisibility(View.INVISIBLE);
                    list_view.setVisibility(View.INVISIBLE);
                    down_unpressed.setVisibility(View.VISIBLE);
                    pay_monthly_title.setVisibility(View.VISIBLE);
                    pay_monthly_box.setVisibility(View.VISIBLE);
                    up_unpressed.setVisibility(View.VISIBLE);
                }
                Lengthsaving();
                shared_preferences.edit().putFloat("interest", (float) i * 12 * 100).apply();
                shared_preferences.edit().putFloat("pay_monthly", (float) a).apply();
                pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
                a_reference = a;
                shared_preferences.edit().putFloat("pay_monthly_reference", (float) a_reference).apply();
                minimum.setVisibility(View.VISIBLE);
                shared_preferences.edit().putString("minimum", "Minimum").apply();
                minimum.setText(getString(R.string.minimum));
            }
        });
    }

    /**instructions for interest_rate and arrow*/
    public void Interest_Rate() {
        interest_rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                list_view.setVisibility(View.VISIBLE);
                down_unpressed.setVisibility(View.INVISIBLE);
                pay_monthly_title.setVisibility(View.INVISIBLE);
                pay_monthly_box.setVisibility(View.INVISIBLE);
                up_unpressed.setVisibility(View.INVISIBLE);
                minimum.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void Arrow_Main() { //we will need to combine 2 public functions into one public function
        arrow_unpressed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    /**Identical to @IBAction func Arrow_Unpressed() in Xcode*/
                    case MotionEvent.ACTION_DOWN:
                        list_view.setVisibility(View.VISIBLE);
                        arrow_unpressed.setVisibility(View.INVISIBLE);
                        arrow_pressed.setVisibility(View.VISIBLE);
                        down_unpressed.setVisibility(View.INVISIBLE);
                        pay_monthly_title.setVisibility(View.INVISIBLE);
                        pay_monthly_box.setVisibility(View.INVISIBLE);
                        up_unpressed.setVisibility(View.INVISIBLE);
                        minimum.setVisibility(View.INVISIBLE);
                        break;
                    /**Identical to @IBAction func Arrow_Pressed() in Xcode*/
                    case MotionEvent.ACTION_UP:
                        arrow_unpressed.setVisibility(View.VISIBLE);
                        arrow_pressed.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_CANCEL: //just in case a user's finger slips outside the object
                        arrow_unpressed.setVisibility(View.VISIBLE);
                        arrow_pressed.setVisibility(View.INVISIBLE);
                        break;
                }
                return false;
            }
        });
    }
    public void listView_Main() { //we can combine 4 internal functions into one public function
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (apr.isChecked()) {
                    /** Identical to func tableView(...numberOfRowsInSection...)*/
                    //see declaration and instantiation of rates_adapter
                    /** Identical to func tableView(...cellForRowAtIndexPath...)*/
                    //see list_view.setAdapter(rates_adapter) in onCreateView()
                    //font is set in listview_center.xml
                    //corner radius is set in rounded_corners.xml
                    /** Identical to func tableView(...didSelectRowAtIndexPath...)*/
                    //color is set in rounded_corners.xml
                    i = rates_reference[position];
                    list_view.setVisibility(View.INVISIBLE);
                    down_unpressed.setVisibility(View.VISIBLE);
                    pay_monthly_title.setVisibility(View.VISIBLE);
                    pay_monthly_box.setVisibility(View.VISIBLE);
                    up_unpressed.setVisibility(View.VISIBLE);
                    interest_rate.setText(rates[position]);
                    int temp = (int) ((p * i + 0.01) * 100);
                    a = (double) (temp) / 100;
                    Lengthsaving();
                    shared_preferences.edit().putFloat("interest", (float) i * 12 * 100).apply();
                    shared_preferences.edit().putFloat("pay_monthly", (float) a).apply();
                    pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
                    a_reference = a;
                    shared_preferences.edit().putFloat("pay_monthly_reference", (float) a_reference).apply();
                    minimum.setVisibility(View.VISIBLE);
                    shared_preferences.edit().putString("minimum", "Minimum").apply();
                    minimum.setText(getString(R.string.minimum));
                    shared_preferences.edit().putInt("position", position).apply();
                }
            }
        });
    }

    /**instructions for down button*/
    public void Down_Main() {
        down_unpressed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    /**Identical to @IBAction func Down_Start_Timer() in Xcode*/
                    case MotionEvent.ACTION_DOWN:
                        handler1 = new Handler(); handler1.postDelayed(Down, 0); //button will function if a user clicks on it
                        //the second instance of handler1 is inserted into Down()
                        down_unpressed.setVisibility(View.INVISIBLE);
                        down_pressed.setVisibility(View.VISIBLE);
                        break;
                    /**Identical to @IBAction func Down_Start_Timer() in Xcode*/
                    case MotionEvent.ACTION_UP:
                        handler1.removeCallbacks(Down);
                        down_unpressed.setVisibility(View.VISIBLE);
                        down_pressed.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_CANCEL: //just in case a user's finger slips outside the object
                        handler1.removeCallbacks(Down);
                        down_unpressed.setVisibility(View.VISIBLE);
                        down_pressed.setVisibility(View.INVISIBLE);
                        break;
                }
                return false;
            }
            /**Identical to func Down() in Xcode*/
            Runnable Down = new Runnable() {
                @Override
                public void run() {
                    handler1.postDelayed(Down, 250); //button will function again every 250 milliseconds, if a user holds on it
                    if (apr.isChecked()) {
                        if (a - 100.0 < (double)((int)((p * i + 0.01) * 100)) / 100) {
                            int temp = (int) ((p * i + 0.01) * 100);
                            a = (double) (temp) / 100;
                            pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
                            a_reference = a;
                            shared_preferences.edit().putFloat("pay_monthly_reference", (float) a_reference).apply();
                            minimum.setVisibility(View.VISIBLE);
                            shared_preferences.edit().putString("minimum", "Minimum").apply();
                            minimum.setText(getString(R.string.minimum));
                        } else {
                            a -= 100.0;
                            pay_monthly_box.setText(String.format(Locale.US, "%,d", (int) a));
                            minimum.setVisibility(View.INVISIBLE);
                            shared_preferences.edit().putString("minimum", "").apply();
                        }
                    } else {
                        if (a - 100.0 < 0.01) {
                            a = 0.01;
                            pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
                            a_reference = a;
                            shared_preferences.edit().putFloat("pay_monthly_reference", (float) a_reference).apply();
                            minimum.setVisibility(View.VISIBLE);
                            shared_preferences.edit().putString("minimum", "Minimum").apply();
                            minimum.setText(getString(R.string.minimum));
                        } else {
                            a -= 100.0;
                            pay_monthly_box.setText(String.format(Locale.US, "%,d", (int) a));
                            minimum.setVisibility(View.INVISIBLE);
                            shared_preferences.edit().putString("minimum", "").apply();
                        }
                    }
                    Lengthsaving();
                    shared_preferences.edit().putFloat("pay_monthly", (float) a).apply();
                }
            };
        });
    }

    /**instructions for up button*/
    public void Up_Main() {
        up_unpressed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    /**Identical to @IBAction func Up_Start_Timer() in Xcode*/
                    case MotionEvent.ACTION_DOWN:
                        handler2 = new Handler(); handler2.postDelayed(Up, 0);
                        //the second instance of handler1 is inserted into Up()
                        up_unpressed.setVisibility(View.INVISIBLE);
                        up_pressed.setVisibility(View.VISIBLE);
                        break;
                    /**Identical to @IBAction func Up_Stop_Timer() in Xcode*/
                    case MotionEvent.ACTION_UP:
                        handler2.removeCallbacks(Up);
                        up_unpressed.setVisibility(View.VISIBLE);
                        up_pressed.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_CANCEL: //just in case a user's finger slips outside the object
                        handler2.removeCallbacks(Up);
                        up_unpressed.setVisibility(View.VISIBLE);
                        up_pressed.setVisibility(View.INVISIBLE);
                        break;
                }
                return false;
            }
            /**Identical to func Up() in Xcode*/
            Runnable Up = new Runnable() {
                @Override
                public void run() {
                    handler2.postDelayed(Up, 250);
                    /*if (a < 100) {
                        a = 100;
                    }
                    else if (a >= 100 && a < 200) { a = 200; }
                    else {
                        a += 100;
                    }*/
                    //informal pilot study and focus groups: made increments increase by 50, instead of 100
                    if (a < 50) {
                        a = 50;
                    }
                    else if (a >= 50 && a < 100) { a = 100; } else if (a >= 100 && a < 150) { a = 150; } else if (a >= 150 && a < 200) { a = 200; }
                    else {
                        a += 50;
                    }
                    minimum.setVisibility(View.INVISIBLE);
                    shared_preferences.edit().putString("minimum", "").apply();
                    if (a >= 500) {
                        minimum.setVisibility(View.VISIBLE);
                        shared_preferences.edit().putString("minimum", "Awesome!").apply();
                        minimum.setText(getString(R.string.awesome));
                    }
                    Lengthsaving();
                    shared_preferences.edit().putFloat("pay_monthly", (float) a).apply();
                    pay_monthly_box.setText(String.format(Locale.US, "%,d", (int) a));
                }
            };
        });
    }

    /**instructions for calculating time and saving*/
    public void Lengthsaving() {
        int j = 0;
        int k = 0;
        double remainingbalance = p;
        double remainingbalance_repay_minimum = p;
        if (i != 0) {
            while (remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100 > a) {
                remainingbalance = remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100 - a;
                j += 1;
            }
            while (remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100 > (double)((int)((p * i + 0.01) * 100)) / 100) {
                remainingbalance_repay_minimum = remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100 - (double)((int)((p * i + 0.01) * 100)) / 100;
                k += 1;
            }
        }
        else {
            j = (int)(Math.ceil((p / a) - 1));
            k = (int)(p / 0.01 - 1);
            remainingbalance = p - a * (double)(j);
            remainingbalance_repay_minimum = 0.01;
        }
        int temp = (int)(Math.floor((double) ((j + 1) / 12)));
        if (a == 0.01) { years.setText("\uD83D\uDE22"); } else { years.setText(String.valueOf(temp)); }
        months.setText(String.valueOf((j + 1) - temp * 12));
        double total_repay_minimum_fromloop = (double)(k) * (double)((int)((p * i + 0.01) * 100)) / 100;        double total_repay_minimum_finalmonth = remainingbalance_repay_minimum + (double)((int)(remainingbalance_repay_minimum * i * 100)) / 100;                                         double total_repay_minimum = total_repay_minimum_fromloop + total_repay_minimum_finalmonth;
        double total = (double)(j) * a + remainingbalance + (double)((int)(remainingbalance * i * 100)) / 100;
        double saved = total_repay_minimum - total;
        if (saved < 0) {
            savings.setText(String.format(Locale.US, "%,d", 0));
        }
        else {
            savings.setText(String.format(Locale.US, "%,d", Math.round(saved)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mymainpage_layout, container, false);
        /**there are no number formatters*/
        /**below are for Android only*/
        loaned = (SeekBar) v.findViewById(R.id.seekBar);
        apr = (Switch) v.findViewById(R.id.switch1);
        interest_rate = (Button) v.findViewById(R.id.button);
        arrow_unpressed = (ImageButton) v.findViewById(R.id.imageButton);
        arrow_pressed = (ImageButton) v.findViewById(R.id.imageButton2);
        list_view = (ListView) v.findViewById(R.id.listView);
        down_unpressed = (ImageButton) v.findViewById(R.id.imageButton3);
        down_pressed = (ImageButton) v.findViewById(R.id.imageButton4);
        pay_monthly_title = (TextView) v.findViewById(R.id.textView4);
        pay_monthly_box = (TextView) v.findViewById(R.id.textView5);
        up_unpressed = (ImageButton) v.findViewById(R.id.imageButton5);
        up_pressed = (ImageButton) v.findViewById(R.id.imageButton6);
        minimum = (TextView) v.findViewById(R.id.textView6);
        years = (TextView) v.findViewById(R.id.textView8);
        months = (TextView) v.findViewById(R.id.textView10);
        savings = (TextView) v.findViewById(R.id.textView13);
        shared_preferences = v.getContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE); //name is optional, but be consistent
        /**Values are called from memory below, but in Xcode values would be placed into memory below*/
        p = (double) shared_preferences.getFloat("loaned", 0);
        i = ((double) shared_preferences.getFloat("interest", 0));
        i_reference = rates_reference[shared_preferences.getInt("position", 0)];
        a = (double) shared_preferences.getFloat("pay_monthly", 0);
        a_reference = (double) shared_preferences.getFloat("pay_monthly_reference", 0);
        /**Android only, to correct for loss in precision--------------------*/
        //the value of p does not lose precision
        int i_correction = ((int) (Math.round(i * 100)));
        i = (double) (i_correction) / 100;
        //the value of i_reference does not lose precision
        int a_correction = ((int) (Math.round(a * 100)));
        a = (double) (a_correction) / 100;
        int a_reference_correction = ((int) (Math.round(a_reference * 100)));
        a_reference = (double) (a_reference_correction) / 100;
        /**------------------------------------------------------------------*/
        i = i / 12 / 100; //need to convert to periodic rate in decimal form

        if (a_reference == a) {
            pay_monthly_box.setText(String.format(Locale.US, "%.2f", a));
        } else {
            pay_monthly_box.setText(String.format(Locale.US, "%,d", Math.round(a)));
        }
        interest_rate.setText(rates[shared_preferences.getInt("position", 0)]);
        minimum.setText(shared_preferences.getString("minimum", null));
        /**Android only--------------------------------------------*/
        Seekbar();
        Switch();
        Interest_Rate();
        Arrow_Main();
        listView_Main();
        Down_Main();
        Up_Main();
        /**--------------------------------------------------------*/
        Lengthsaving();
        arrow_pressed.setVisibility(View.INVISIBLE);
        rates_adapter = new ArrayAdapter<>(v.getContext(), R.layout.listview_center, rates);
        list_view.setAdapter(rates_adapter);
        list_view.setVisibility(View.INVISIBLE);
        list_view.setVerticalScrollBarEnabled(false);
        list_view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == MotionEvent.ACTION_MOVE;
            }
        });
        //left separator inset is already zero
        down_pressed.setVisibility(View.INVISIBLE);
        up_pressed.setVisibility(View.INVISIBLE);
        return v;
    }
}
