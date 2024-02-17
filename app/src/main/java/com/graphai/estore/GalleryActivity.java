package com.graphai.estore;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") &&getIntent().hasExtra("image_discount") ){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imagePrice = getIntent().getStringExtra("image_price");
            String imageDiscount = getIntent().getStringExtra("image_discount");

            setImage(imageUrl, imageName,imagePrice,imageDiscount);
        }
    }


    private void setImage(String imageUrl, String imageName, String imagePrice, String imageDiscount){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView price = findViewById(R.id.price);
        price.setText(imagePrice);

        TextView discount =findViewById(R.id.discount);
        discount.setText(imageDiscount);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}
