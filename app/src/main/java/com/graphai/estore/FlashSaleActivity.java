package com.graphai.estore;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FlashSaleActivity extends AppCompatActivity {
    /// tabLayout ///

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    ////COUNTDOWN VARIABLE//////\
    private int seconds;
    boolean isRunningOffer;
    /////////////////////
    TextView textView;
    Button button;
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String>mPrices = new ArrayList<>();
    private ArrayList<String>mDiscount = new ArrayList<>();

    private void countDownControl(){
        seconds = 86400;
        isRunningOffer = true;

        /////////////COUNTDOWN VIEW//////////////
        final TextView hourView = (TextView) findViewById(R.id.countdown_hour);
        final TextView minuteView = (TextView) findViewById(R.id.countdown_minute);
        final TextView secondView = (TextView) findViewById(R.id.countdown_second);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;
                --seconds;
                if(isRunningOffer){
                    if(hours < 10)
                        hourView.setText("0"+Integer.toString(hours));
                    else
                        hourView.setText(Integer.toString(hours));
                    if(minutes < 10)
                        minuteView.setText("0"+Integer.toString(minutes));
                    else
                        minuteView.setText(Integer.toString(minutes));
                    if(sec < 10)
                        secondView.setText("0"+Integer.toString(sec));
                    else
                        secondView.setText(Integer.toString(sec));

                }
                handler.postDelayed(this, 1000);
                if(hours == 0 && minutes == 0 && seconds == 0){
                    hourView.setText("00");
                    minuteView.setText("00");
                    secondView.setText("00");
                    isRunningOffer = false;
                    handler.removeCallbacks(this);
                }

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_sale);

        /// tabLayout ///
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FlashSaleFragment(),"00:00");
        adapter.AddFragment(new MessageFragment(),"00:00");
        adapter.AddFragment(new FlashSaleFragment(),"00:00");

        /// end tabLayout ///

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        Toolbar toolbar = findViewById(R.id.toolbar_flash_sale);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        countDownControl();

    }


    /// tabLayout Adapter
    public class ViewPageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> FragmentListTitle = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentListTitle.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentListTitle.get(position);
        }

        public void AddFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            FragmentListTitle.add(title);
        }
    }
}

