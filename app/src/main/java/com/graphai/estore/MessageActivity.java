/*
package com.graphai.estore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private Intent intent;
    private ImageButton orderButton,notificationButton,promoButton;
    RecyclerView recyclerView;
    MessageAdapter adapter;
    List<MessageProduct> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        orderButton = (ImageButton)findViewById(R.id.order_button);
        notificationButton = (ImageButton)findViewById(R.id.notification_button);
        promoButton = (ImageButton)findViewById(R.id.promo_button);

        //onclick listener for OderButton,NotificationButton,PromoButton
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent=new Intent(MessageActivity.this,OrderActivity.class));
            }
        });
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent=new Intent(MessageActivity.this,NotificationActivity.class));
            }
        });
        promoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent = new Intent(MessageActivity.this,PromoActivity.class));
            }
        });


        productList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.iphonex));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_2));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_3));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_4));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.iphonex));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        productList.add(new MessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));

        adapter = new MessageAdapter(this,productList);
        recyclerView.setAdapter(adapter);

    }
}
*/
