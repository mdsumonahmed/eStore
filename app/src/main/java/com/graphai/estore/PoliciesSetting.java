package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class PoliciesSetting extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies_setting);

        tabLayout = findViewById(R.id.tab_layout_id);
        viewPager = findViewById(R.id.view_pager_id);

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new PrivacyPolicyFragment(),"Privacy Policy");
        adapter.AddFragment(new TermsConditionFragment(),"Terms & Conditions");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
