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

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private List<MessageProduct>productList;

    public MessageAdapter(Context context, List<MessageProduct> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.message_view_layout,null);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

       MessageProduct product = productList.get(position);

       holder.textViewTitle.setText(product.getTitle());
       holder.textViewDesc.setText(product.getShortdesc());
       holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle,textViewDesc;
        ImageView imageView;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView)itemView.findViewById(R.id.text_view_title);
            textViewDesc = (TextView)itemView.findViewById(R.id.text_view);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
