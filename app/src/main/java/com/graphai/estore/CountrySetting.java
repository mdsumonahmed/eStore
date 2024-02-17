package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class CountrySetting extends AppCompatActivity {

    RadioButton bangladesh;
    RadioButton sriLanka;
    RadioButton nepal;
    RadioButton pakistan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_setting);

        bangladesh = (RadioButton)findViewById(R.id.bangladesh_radio_button);
        sriLanka = (RadioButton)findViewById(R.id.sri_lanka_radio_button);
        nepal = (RadioButton)findViewById(R.id.nepal_radio_button);
        pakistan = (RadioButton)findViewById(R.id.pakistan_radio_button);

        RadioGroup teamGroup = (RadioGroup) findViewById(R.id.team_group);
        int selectedId = teamGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

    }

}
