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

public class BottomSheetRecyclerAdapter extends RecyclerView.Adapter<BottomSheetRecyclerAdapter.BottomSheetRecyclerViewHolder> {
    private Context context;
    private List<Bottomsheet_recycler_design_child> bottomsheetList;

    public BottomSheetRecyclerAdapter(Context context, List<Bottomsheet_recycler_design_child> bottomsheetList) {
        this.context = context;
        this.bottomsheetList = bottomsheetList;
    }

    @NonNull
    @Override
    public BottomSheetRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bottom_sheet_recyler_layout,null);
        return new BottomSheetRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomSheetRecyclerViewHolder holder, int position) {
        final Bottomsheet_recycler_design_child bottomsheet_recycler_design_childClass = bottomsheetList.get(position);
        //Bottomsheet_recycler_design_childClass design = productList.get(position);
        holder.image.setImageDrawable(context.getResources().getDrawable(bottomsheet_recycler_design_childClass.image));
        holder.title.setText(bottomsheet_recycler_design_childClass.title);
        holder.shoerdesc.setText(bottomsheet_recycler_design_childClass.shortdesc);
        holder.price.setText(bottomsheet_recycler_design_childClass.price);
    }

    @Override
    public int getItemCount() {
        return bottomsheetList.size();
    }


    public class BottomSheetRecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,shoerdesc,price;

        public BottomSheetRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.text_view_title);
            shoerdesc = itemView.findViewById(R.id.text_view_short_desc);
            price = itemView.findViewById(R.id.text_view_price);
        }
    }
}
