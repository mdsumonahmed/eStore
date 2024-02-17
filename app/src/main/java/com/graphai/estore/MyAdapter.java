package com.graphai.estore;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();
    private ArrayList<String> mDiscount = new ArrayList<>();
    private Context mContext;

    public MyAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mPrices, ArrayList<String>mDiscount, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mPrices = mPrices;
        this.mDiscount= mDiscount;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flash_sale_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.prices.setText(String.format("৳ %s",mPrices.get(position)));
        holder.discount.setText((mDiscount.get(position)));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, ProductShowActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                intent.putExtra("image_price", mPrices.get(position));
                intent.putExtra("image_discount", mDiscount.get(position));

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        TextView prices;
        TextView discount;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            prices= itemView.findViewById(R.id.price);
            discount =itemView.findViewById(R.id.discount);
            parentLayout = itemView.findViewById(R.id.flash_sale_parent_layout);

        }
    }
}
