package com.graphai.estore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.graphai.estore.AddressBookSetting;
import com.graphai.estore.R;
import com.graphai.estore.model.AddressList;

import java.util.Collection;
import java.util.List;

public class AddressSettingRecyclerViewAdapter extends RecyclerView.Adapter <AddressSettingRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<AddressList> mData;

    public AddressSettingRecyclerViewAdapter(Context mContext, List<AddressList> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_address,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_view_name.setText(mData.get(position).getName());
        holder.text_view_edit.setText(mData.get(position).getEdit());
        holder.text_view_number.setText(mData.get(position).getNumber());
        holder.text_view_home.setText(mData.get(position).getHome());
        holder.text_view_child_location.setText(mData.get(position).getChildLocation());
        holder.text_view_location.setText(mData.get(position).getLocation());
        holder.text_view_ship_bill.setText(mData.get(position).getShippingBill());
        holder.image_view_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, AddressBookSetting.class);

                intent.putExtra("Name",mData.get(position).getName());
                intent.putExtra("Edit",mData.get(position).getEdit());
                intent.putExtra("Number",mData.get(position).getNumber());
                intent.putExtra("Home",mData.get(position).getHome());
                intent.putExtra("Child Location",mData.get(position).getChildLocation());
                intent.putExtra("Location",mData.get(position).getLocation());
                intent.putExtra("Shipping Bill",mData.get(position).getShippingBill());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view_location;
        TextView text_view_name;
        TextView text_view_edit;
        TextView text_view_number;
        TextView text_view_home;
        TextView text_view_child_location;
        TextView text_view_location;
        TextView text_view_ship_bill;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view_location = itemView.findViewById(R.id.image_view_location_id);
            text_view_name = itemView.findViewById(R.id.text_view_name_id);
            text_view_edit = itemView.findViewById(R.id.text_view_edit_id);
            text_view_number = itemView.findViewById(R.id.text_view_number_id);
            text_view_home = itemView.findViewById(R.id.text_view_home_id);
            text_view_child_location = itemView.findViewById(R.id.text_view_child_location_id);
            text_view_location = itemView.findViewById(R.id.text_view_location_id);
            text_view_ship_bill = itemView.findViewById(R.id.text_view_ship_bill_id);
        }
    }
}
