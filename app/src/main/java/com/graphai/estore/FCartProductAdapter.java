package com.graphai.estore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FCartProductAdapter extends RecyclerView.Adapter<FCartProductAdapter.FCraftProductViewHolder> {

    private Context context;
    private List<FCartProduct> fCartProductList;

    public FCartProductAdapter(Context context, List<FCartProduct> fCartProductList) {
        this.context = context;
        this.fCartProductList = fCartProductList;
    }

    @NonNull
    @Override
    public FCraftProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_cart_list, null);
        return new FCraftProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FCraftProductViewHolder holder, int position) {
        final FCartProduct fCartProduct = fCartProductList.get(position);
        holder.textViewTitle.setText(fCartProduct.getTitle());
        holder.textViewDesc.setText(fCartProduct.getShortdesc());
        // holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(fCartProduct.getPrice()));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(fCartProduct.getImage()));

        //holder.count.setText(String.valueOf(product.getCount()));
        holder.count.setText(String.valueOf(fCartProduct.getCount()));
        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //product.setCount(product.getCount() + 1);
                //holder.count.setText(String.valueOf(product.getCount()));
            fCartProduct.setCount(fCartProduct.getCount() + 1);
            holder.count.setText(String.valueOf(fCartProduct.getCount()));
            }
        });

        holder.minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fCartProduct.getCount() > 1) {
                    fCartProduct.setCount(fCartProduct.getCount() - 1);
                    holder.count.setText(String.valueOf(fCartProduct.getCount()));
                    //product.setCount(product.getCount() - 1);
                    //holder.count.setText(String.valueOf(product.getCount()-1));
                    //product.setCount(product.getCount() - 1);
                    //holder.count.setText(product.getCount());
                }
            }
        });


        holder.getBoucherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetClass bottomSheet = new BottomSheetClass();
                bottomSheet.show(((AppCompatActivity) context).getSupportFragmentManager(),"bottomSheetClass");


            }
        });


    }

    @Override
    public int getItemCount() {
        return fCartProductList.size();
    }

    public class FCraftProductViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewPrice, count;
        AppCompatCheckBox checkBox;
        Button minusbtn, plusbtn ,getBoucherbtn;

    public FCraftProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textViewTitle = itemView.findViewById(R.id.textViewTitleid);
        textViewDesc = itemView.findViewById(R.id.textViewShortDescid);
        // textViewRating =itemView.findViewById(R.id.textViewRatingid);
        textViewPrice = itemView.findViewById(R.id.textViewPriceid);
        count = itemView.findViewById(R.id.counter_text);
        checkBox = itemView.findViewById(R.id.checkid);
        minusbtn = itemView.findViewById(R.id.minusbtn);
        plusbtn = itemView.findViewById(R.id.plusbtn);
        getBoucherbtn=itemView.findViewById(R.id.btngetVoucherClick);

    }
}

}
