package com.graphai.estore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderAdapter adapter;
    List<OrderProduct>productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        productList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(new OrderProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_7));
        productList.add(new OrderProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        productList.add(new OrderProduct("Samsung Galaxy S10e"," Dual Pixel PDAF, OIS, 1.4 & 1.0 μm, 77° & 123° view, f/1.5-f/2.4 & f/2.2, bokeh, panorama & more, Up to Ultra HD 4K (2160p), HDR, dual-video recording, VDIS",R.drawable.phone_3));
        productList.add(new OrderProduct("Samsung Galaxy S10e"," Dual Pixel PDAF, OIS, 1.4 & 1.0 μm, 77° & 123° view, f/1.5-f/2.4 & f/2.2, bokeh, panorama & more, Up to Ultra HD 4K (2160p), HDR, dual-video recording, VDIS",R.drawable.phone_3));
        productList.add(new OrderProduct("Samsung Galaxy S10e"," Dual Pixel PDAF, OIS, 1.4 & 1.0 μm, 77° & 123° view, f/1.5-f/2.4 & f/2.2, bokeh, panorama & more, Up to Ultra HD 4K (2160p), HDR, dual-video recording, VDIS",R.drawable.phone_3));
        productList.add(new OrderProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_7));
        productList.add(new OrderProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));

        adapter = new OrderAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
}
