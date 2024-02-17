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

public class CollectionChildAdapter extends RecyclerView.Adapter<CollectionChildAdapter.CollectionChildViewHolder>{
        private Context context;
        private List<CollectionChild>childList;

    public CollectionChildAdapter(Context context, List<CollectionChild> childList) {
        this.context = context;
        this.childList = childList;
    }

    @NonNull
    @Override
    public CollectionChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.collection_child_layout,parent,false);
        return new CollectionChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionChildViewHolder holder, int position) {
         CollectionChild child = childList.get(position);
         holder.textTitle.setText(child.getTextTitle());
         holder.textDesc.setText(child.getTextDesc());
         holder.imageLeft.setImageDrawable(context.getResources().getDrawable(child.getImageLeft()));
         holder.imageRight.setImageDrawable(context.getResources().getDrawable(child.getImageRight()));

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    class CollectionChildViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle,textDesc;
        ImageView imageLeft,imageRight;
     public CollectionChildViewHolder(@NonNull View itemView) {
         super(itemView);
         textTitle = (TextView)itemView.findViewById(R.id.text_view_title);
         textDesc = (TextView)itemView.findViewById(R.id.text_view_desc);
         imageLeft = (ImageView)itemView.findViewById(R.id.image_view_left);
         imageRight = (ImageView)itemView.findViewById(R.id.image_view_right);
     }
 }

}
