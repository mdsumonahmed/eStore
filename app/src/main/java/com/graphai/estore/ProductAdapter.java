package com.graphai.estore;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CustomViewHolder> {

    Context context;
    class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;
        TextView productRating;
        RatingBar ratingBar;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productRating = itemView.findViewById(R.id.product_rating);
            ratingBar = itemView.findViewById(R.id.rating_bar);
        }
    }

    private List<ProductModel> productList;

    public ProductAdapter(Context context, List<ProductModel> productList) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (productList.get(position).getWhatView().equalsIgnoreCase("list")) {
            return R.layout.list_item_layout;
        } else {
            return R.layout.grid_item_layout;
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.CustomViewHolder holder, int position) {
        if (holder.getItemViewType() == R.layout.list_item_layout) {
            holder.productImage.setImageResource(productList.get(position).getProductImage());
        }else{
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_launcher_background);
            Glide.with(context)
                    .load(productList.get(position).getProductImage())
                    .apply(requestOptions)
                    .into(holder.productImage);
        }
        holder.productName.setText(productList.get(position).getProductName());
        holder.productPrice.setText(String.format("৳ %s", insertComma(productList.get(position).getProductPrice())));
        holder.productRating.setText(String.valueOf(productList.get(position).getProductRating()));
        holder.ratingBar.setRating(productList.get(position).getProductRating());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    private String insertComma(int number){
        String str = String.valueOf(number);
        StringBuilder s = new StringBuilder();
        char[] ch = str.toCharArray();
        int count=0;
        for(int i=ch.length-1;i>=0;i--)
        {
            if(count==3) {
                s.append(',');
                count=0;
            }
            s.append(ch[i]);
            count++;
        }
        s.reverse();
        return s.toString();
    }
}

