package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MessageSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_setting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
