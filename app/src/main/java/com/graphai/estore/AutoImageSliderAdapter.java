package com.graphai.estore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class AutoImageSliderAdapter extends SliderViewAdapter<AutoImageSliderAdapter.ImageSliderVH>{

    private Context context;

    public AutoImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ImageSliderVH onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_auto_image_slider_list,null);
        return new ImageSliderVH(view);
    }

    @Override
    public void onBindViewHolder(ImageSliderVH viewHolder, int position) {
        switch (position){
            case 0:
                viewHolder.image.setImageResource(R.drawable.phone_1);
                break;

            case 2:
                viewHolder.image.setImageResource(R.drawable.phone_2);
                break;

            case 3:
                viewHolder.image.setImageResource(R.drawable.phone_3);
                break;

            case 4:
                viewHolder.image.setImageResource(R.drawable.phone_4);
                break;

            default:
                viewHolder.image.setImageResource(R.drawable.phone_5);
                break;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    class ImageSliderVH extends SliderViewAdapter.ViewHolder{
        View itemView;
        ImageView image;
        public ImageSliderVH(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            this.itemView = itemView;
        }
    }
}
