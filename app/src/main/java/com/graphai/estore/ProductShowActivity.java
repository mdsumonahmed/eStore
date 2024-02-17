package com.graphai.estore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductShowActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView userAddress,userAddressChangeButton,deliveryFee,positive_seller_rating,goToStore;
    private TextView textView;
    private RatingBar ratingBar;
    private ListView listView;
    private CheckBox authentic,returnInDays;

    ArrayList<ProductInfo> productInfos = new ArrayList<ProductInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show);

        productInfos.add(new ProductInfo(12345, "Galaxy J7",
                (ProductInfo.setData("Brand: Samsung\nNO RETURN applicableif the seal is broken\nProcessor: Dual-Core 1.4GHz Cyclone Processor\nROM 32 GB and RAM 3 GB\nNano-Sim\nRear Camera: 13 Megapixel Camera\nFront Camera: 8 Megapixel\nDisplay: 5.0-Inch LED-backlit\nSensor: Fingerprint, accelerometer, compass")),
                (ProductInfo.setData("* Power Packed Performance\n* The real 4G experience with Ultra Data Saving")),
                "SM-J700FZWD", 12000));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductShowActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.button_id);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductShowActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productInfos.get(0).getProductFeature());

        TextView productName = (TextView) findViewById(R.id.product_name);
        TextView productPrice = (TextView) findViewById(R.id.product_price);
        TextView productFullMoel = (TextView) findViewById(R.id.product_full_model);
        TextView shortDescriptionOne = (TextView) findViewById(R.id.short_description_one);
        TextView shortDescriptionTwo = (TextView) findViewById(R.id.short_description_two);

        productName.setText(productInfos.get(0).getName());
        productPrice.setText(Integer.toString(productInfos.get(0).getPrice()) + "TK");
        productFullMoel.setText(productInfos.get(0).getFullModel());
        shortDescriptionOne.setText((productInfos.get(0).getShortDescription()).get(0));
        shortDescriptionTwo.setText((productInfos.get(0).getShortDescription()).get(1));

        ListView listView = (ListView) findViewById(R.id.product_feature);
        listView.setAdapter(adapter);


        userAddress=findViewById(R.id.user_address_id);
        deliveryFee=findViewById(R.id.delivery_fee);
        positive_seller_rating=findViewById(R.id.positive_seller_text_percent_id);



        (userAddressChangeButton=findViewById(R.id.address_change_button_id)).setOnClickListener((View.OnClickListener) this);
        (goToStore = findViewById(R.id.go_to_store_button_id)).setOnClickListener((View.OnClickListener) this);

        /*Sumon*/

        //for rattingBar
        textView = (TextView) findViewById(R.id.ratting_text_id);
        ratingBar = (RatingBar) findViewById(R.id.rattingbar_id);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(""+rating);
            }
        });

        //for comment
        listView = (ListView) findViewById(R.id.listView_id);

        String[] comment = getResources().getStringArray(R.array.user_comment_array);
        ArrayAdapter<String> commentAdapter = new ArrayAdapter<String>(ProductShowActivity.this,R.layout.show_array_list,R.id.textView_forArray_id,comment);
        listView.setAdapter(commentAdapter);
    }

    /*Ryahan*/

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
