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

public class FMessageAdapter extends RecyclerView.Adapter<FMessageAdapter.FragmentMessageViewHolder> {
    private Context context;
    private List<FMessageProduct> productListMessage;

    public FMessageAdapter(Context context, List<FMessageProduct> productListMessage) {
        this.context = context;
        this.productListMessage = productListMessage;
    }

    @NonNull
    @Override
    public FragmentMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.fragment_message_list,null);
        return new FragmentMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageViewHolder holder, int position) {
        FMessageProduct product = productListMessage.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));
    }

    @Override
    public int getItemCount() {
        return productListMessage.size();
    }

    class FragmentMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewDesc;
        ImageView imageView;
        public FragmentMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView)itemView.findViewById(R.id.text_view_title);
            textViewDesc = (TextView)itemView.findViewById(R.id.text_view);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
