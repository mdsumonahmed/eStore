package com.graphai.estore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FlashSaleFragment extends Fragment {

    OnArticleSelectedListener listener;

    public interface OnArticleSelectedListener {
        //public void onArticleSelected(Uri articleUri);
    }

    RecyclerView recyclerView;
    MyAdapter adapter;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();
    private ArrayList<String> mDiscount = new ArrayList<>();
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_flash_sale, container, false);

       recyclerView = view.findViewById(R.id.recyclerViewId);
        initImageBitmaps();


       return view;
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://images.costco-static.com/ImageDelivery/imageService?profileId=12026540&itemId=1315165-847&recipeName=680");
        mNames.add("Lenovo idapad");
        mPrices.add("50000");
        mDiscount.add("20 % ");

        mImageUrls.add("https://cdn.tmobile.com/content/dam/t-mobile/en-p/cell-phones/apple/apple-iphone-xs-max/gold/Apple-iPhoneXsMax-Gold-1-3x.jpg");
        mNames.add("iphone Max");
        mPrices.add("135000");
        mDiscount.add("20 % ");

        mImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/61O%2Bh99cFEL._SL1334_.jpg");
        mNames.add("Samsung S10");
        mPrices.add("99999");
        mDiscount.add("20 % ");

        mImageUrls.add("https://ae01.alicdn.com/kf/HTB14BXRQXXXXXbLXXXXq6xXFXXXi/50-pcs-Hybrid-Armor-Case-For-OPPO-F2-F1-oft-TPU-Back-Cover-for-OPPO-NEO7.jpg_640x640.jpg");
        mNames.add("Oppo f2");
        mPrices.add("14000");
        mDiscount.add("20 % ");

        mImageUrls.add("https://www.bigw.com.au/medias/sys_master/images/images/h51/he7/12176623435806.jpg");
        mNames.add("iPhone 6");
        mPrices.add("35000");
        mDiscount.add("20 % ");

        mImageUrls.add("https://i1.wp.com/gizmologi.id/wp-content/uploads/2018/05/OPPO-F7-Youth-phone-600x600.jpg");
        mNames.add("Oppo f7");
        mPrices.add("59999");
        mDiscount.add("20 % ");


        mImageUrls.add("https://support.apple.com/library/APPLE/APPLECARE_ALLGEOS/SP770/iphonex.png");
        mNames.add("iPhone X");
        mPrices.add("110000 ");
        mDiscount.add("20 % ");

        mImageUrls.add("https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F813416%252F4953098c-6d99-477a-acd2-a16d08474246.jpg%252Ffit-in__1440x0.jpg?signature=_Ecea3c0rM11wfN0A-oOg70SByE=&source=https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com");
        mNames.add("MackBook Pro");
        mPrices.add("14000");
        mDiscount.add("20 % ");

        mImageUrls.add("https://o.aolcdn.com/images/dims?quality=85&image_uri=https%3A%2F%2Fmedia-mbst-pub-ue1.s3.amazonaws.com%2Fcreatr-uploaded-images%2F2018-11%2Fd3642120-e12e-11e8-b7f6-d080f65615ce&client=amp-blogside-v2&signature=86aa148e8c6cd5d55b2ac8d3fea2646cd63e4e47");
        mNames.add("MacBook Air");
        mPrices.add("240000");
        mDiscount.add("20 % ");

        initRecyclerView();
    }
    @SuppressLint("WrongConstant")
    private void initRecyclerView(){
        //recyclerView = view.findViewById(R.id.recyclerViewId);
        adapter = new MyAdapter(mNames,mImageUrls,mPrices ,mDiscount,mContext );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        /*try {
            listener = (OnArticleSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
*/
    }
}
