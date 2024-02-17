package com.graphai.estore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PromoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PromoAdapter adapter;
    List<PromoProduct> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        productList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(new PromoProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.promo_pic));
        productList.add(new PromoProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.promo_pic));

        adapter = new PromoAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
}
