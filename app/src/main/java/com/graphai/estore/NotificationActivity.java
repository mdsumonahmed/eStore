package com.graphai.estore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    NotificationAdapter adapter;
    private List<NotificationProduct>productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);

        productList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList.add(new NotificationProduct("Apple iPhone X - Smartphone ","Display: Super AMOLED capacitive touchscreen, Glass: Ion-strengthened glass, oleophobic coating",R.drawable.iphonex));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));
        productList.add(new NotificationProduct("Apple iPhone X - Smartphone ","Display: Super AMOLED capacitive touchscreen, Glass: Ion-strengthened glass, oleophobic coating",R.drawable.iphonex));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));
        productList.add(new NotificationProduct("Samsung Galaxy A30 ","Smartphone 6.4\" - 4GB RAM - 64GB ROM - 16MP,Expandable Storage: 512 GB,econdary Camera Features: F2.0 Aperture",R.drawable.phone_1));

        adapter = new NotificationAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
}
