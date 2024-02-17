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

public class ButtonSilderAdapter extends RecyclerView.Adapter<ButtonSilderAdapter.ButtonSilderViewHolder>{
    private Context context;
    private List<ButtonSilder>silderList;

    public ButtonSilderAdapter(Context context, List<ButtonSilder> silderList) {
        this.context = context;
        this.silderList = silderList;
    }

    @NonNull
    @Override
    public ButtonSilderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.button_silder_layout,null);
        return new ButtonSilderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonSilderViewHolder holder, int position) {
        ButtonSilder silder = silderList.get(position);
        holder.image.setImageDrawable(context.getResources().getDrawable(silder.getIcon()));
        holder.name.setText(silder.getIcon_name());
    }

    @Override
    public int getItemCount() {
        return silderList.size();
    }

    class ButtonSilderViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        public ButtonSilderViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image_view);
            name = (TextView)itemView.findViewById(R.id.text_view);
        }
    }
}
