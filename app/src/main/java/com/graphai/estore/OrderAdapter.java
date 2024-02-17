package com.graphai.estore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

   private Context context;
   private List<OrderProduct>productList;

    public OrderAdapter(Context context, List<OrderProduct> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_view_layout,null);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderProduct product = productList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle,textViewDesc;
        private ImageView imageView;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = (TextView)itemView.findViewById(R.id.text_view_title);
            textViewDesc = (TextView)itemView.findViewById(R.id.text_view);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
