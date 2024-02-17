package com.graphai.estore;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DeleveryActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userAddress,userAddressChangeButton,deliveryFee,positive_seller_rating,goToStore;
    private CheckBox authentic,returnInDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delevery);

        Toolbar toolbar = findViewById(R.id.toolba_delevery);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.delivery_option));


        userAddress=findViewById(R.id.user_address_id);
        deliveryFee=findViewById(R.id.delivery_fee);
        positive_seller_rating=findViewById(R.id.positive_seller_text_percent_id);



        (userAddressChangeButton=findViewById(R.id.address_change_button_id)).setOnClickListener(this);
        (goToStore = findViewById(R.id.go_to_store_button_id)).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.address_change_button_id:
                Toast.makeText(this, "Address Changed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.go_to_store_button_id:
                Toast.makeText(this, "You are going to ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

