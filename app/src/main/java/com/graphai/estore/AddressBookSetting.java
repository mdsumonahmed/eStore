package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graphai.estore.model.AddressList;

import java.util.ArrayList;
import java.util.List;

public class AddressBookSetting extends AppCompatActivity {

    private Context mContext;
    private TextView name, edie, number, home, childLocation, location, shippingBill;
    private ImageView image;
    RecyclerView mRecyclerView;
    AddressSettingRecyclerViewAdapter addressSettingRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book_setting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<AddressList> addressLists = new ArrayList<>();

        addressLists .add(new AddressList("Azizul Alam","Edit","1314667487","Home","jatrabari","Dhaka,Dhaka - South,Jatrabari","Default shipping & billing Address",R.drawable.location));
        addressLists .add(new AddressList("Sumon Ahmed","Edit","1278788383","Home","farmgate","Dhaka,Dhaka - South,Farmgate","Default shipping & billing Address",R.drawable.location));

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_address_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        AddressSettingRecyclerViewAdapter addressSettingRecyclerViewAdapter = new AddressSettingRecyclerViewAdapter(this,addressLists);
        mRecyclerView.setAdapter(addressSettingRecyclerViewAdapter);
    }
}
