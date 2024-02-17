package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  //Hides the title
        //super.onCreate(savedInstanceState);
        getSupportActionBar().hide();   //Hides title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //Makes current display fullscreen

        setContentView(R.layout.activity_main);

        /*Code from Mostofa Kamal to automatically load Home page*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        }, 2000);


        /*Code from google to auto load home activity*/
       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        }, 2000);*/

    }
}
