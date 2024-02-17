package com.graphai.estore;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductCollectionAdapter extends RecyclerView.Adapter<ProductCollectionAdapter.ProductCollectionViewHolder>{

    private Context context;
    private List<ProductCollection>collectionList;

    public ProductCollectionAdapter(Context context, List<ProductCollection> collectionList) {
        this.context = context;
        this.collectionList = collectionList;
    }

    @NonNull
    @Override
    public ProductCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_collection,null);
        return new ProductCollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCollectionViewHolder holder, int position) {
        ProductCollection product = collectionList.get(position);

        holder.productImage.setImageDrawable(context.getResources().getDrawable(product.image));
        holder.productShortDesc.setText(product.shortDesc);
        holder.productPrice.setText(product.price);
        holder.productOldPrice.setPaintFlags(holder.productOldPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.productRatting.setRating(product.rating);
       /* SpannableString ss = new SpannableString((CharSequence) product.oldPrice);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        ss.setSpan(strikethroughSpan,1,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
*/
    }

    @Override
    public int getItemCount() {
        return collectionList.size();
    }

    class ProductCollectionViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        TextView productShortDesc,productPrice,productOldPrice;
        RatingBar productRatting;
        public ProductCollectionViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.image_view_product);
            productShortDesc = itemView.findViewById(R.id.text_view_short_desc);
            productPrice = itemView.findViewById(R.id.text_view_price);
            productOldPrice = itemView.findViewById(R.id.text_view_old_price);
            productRatting = itemView.findViewById(R.id.rating_bar);

        }
    }
}
