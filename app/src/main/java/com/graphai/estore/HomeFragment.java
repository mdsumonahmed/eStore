package com.graphai.estore;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.INVISIBLE;

public class HomeFragment extends Fragment  {

    private ListView listView;
    private SearchView searchView;
    /*private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;*/
    SliderView sliderView;

    RecyclerView recyclerView;
    ButtonSilderAdapter adapter;
    List<ButtonSilder> silderList;
    ImageView imageViewGif;
    TextView textViewHour;
    TextView textViewMinute;
    TextView textViewSecond;

    CollectionChildAdapter childAdapter;
    List<CollectionChild>childList;
    RecyclerView clolectionRecyclerView;

    RecyclerView recyclerViewCollection;
    List<ProductCollection>collectionList;
    ProductCollectionAdapter collectionAdapter;

    private int seconds;
    boolean isRunningOffer;

    Button button;
    ImageView imageView;
    LinearLayout product;
    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String>mPrices = new ArrayList<>();
    private ArrayList<String>mdiscount = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        textViewHour = view.findViewById(R.id.countdown_hour);
        textViewMinute = view.findViewById(R.id.countdown_minute);
        textViewSecond = view.findViewById(R.id.countdown_second);
//////////////////////////////////////////////////////////////////////////////////////
        // auto image slider ///
        sliderView = view.findViewById(R.id.sliderView);
        AutoImageSliderAdapter sliderAdapter = new AutoImageSliderAdapter(getContext());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(2);
        sliderView.startAutoCycle();


        ImageView imageViewGif = null;
        imageViewGif = view.findViewById(R.id.image_view_gif);
        String gifURL = "https://media0.giphy.com/media/10nbkHA3gwrCes/giphy.gif?cid=790b76115d1da5f4547a507436a49bdc&rid=giphy.gif";
        Glide.with(HomeFragment.this).load(gifURL).into(imageViewGif);

        silderList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_View_Id);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        silderList.add(new ButtonSilder(R.drawable.ic_notification,"notics"));
        silderList.add(new ButtonSilder(R.drawable.ic_airplane,"Global\nConnection"));
        silderList.add(new ButtonSilder(R.drawable.ic_list,"Categories"));
        silderList.add(new ButtonSilder(R.drawable.ic_local_grocery_store_black_24dp,"Store"));
        silderList.add(new ButtonSilder(R.drawable.laptop,"Computer"));
        silderList.add(new ButtonSilder(R.drawable.ic_open_book,"Book"));
        silderList.add(new ButtonSilder(R.drawable.ic_order,"Order"));

        adapter = new ButtonSilderAdapter(getContext(),silderList);
        recyclerView.setAdapter(adapter);

        clolectionRecyclerView = (RecyclerView) view.findViewById(R.id.include_recycler_view);
        childList = new ArrayList<>();
        clolectionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.iphonex));
        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.phone_5));
        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.phone_5));
        childList.add(new CollectionChild("Test","data",R.drawable.hedphone,R.drawable.phone_5));

        childAdapter = new CollectionChildAdapter(getContext(),childList);
        clolectionRecyclerView.setAdapter(childAdapter);

        recyclerViewCollection = view.findViewById(R.id.recycler_view_collection);
        collectionList = new ArrayList<>();
        recyclerViewCollection.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        collectionList.add(new ProductCollection(R.drawable.contrainer,"Sell off","5,00","6,00",5));
        collectionList.add(new ProductCollection(R.drawable.phone_1,"Display: 6.1-inch (diagonal) all-screen LCD Multi-Touch display with IPS technology (828 x 1792);  19.5:9 ratio (~326 ppi density)","20,000","25,000",3));
        collectionList.add(new ProductCollection(R.drawable.shart,"Newly plus size full printing clothes fashion womans wild side blouse","2,000","3,000",4));
        collectionList.add(new ProductCollection(R.drawable.book_c,"Spical Offer for book","2,000","3,000",2));
        collectionList.add(new ProductCollection(R.drawable.electronics,"Get the first look at collaborations, new products, events, sales & more.","5,000","6,000",5));
        collectionList.add(new ProductCollection(R.drawable.book_d,"Eid Collection","5,000","6,000",4));

        collectionAdapter = new ProductCollectionAdapter(getContext(),collectionList);
        recyclerViewCollection.setAdapter(collectionAdapter);

        countDownControl();

        button = (Button) view.findViewById(R.id.shop_more);
        button = (Button) view.findViewById(R.id.button_shop_more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getId()==R.id.shop_more){
                    Intent intent = new Intent(HomeFragment.this.getContext(), FlashSaleActivity.class);
                    startActivity(intent);
                }
                if (button.getId()==R.id.button_shop_more){
                    Intent intent = new Intent(HomeFragment.this.getContext(), MessageFragment.class);
                    startActivity(intent);
                }

            }
        });


        product = view.findViewById(R.id.product);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),FlashSaleActivity.class);
                startActivity(intent);
            }
        });
        listView = view.findViewById(R.id.result_list);

        return view;
    }

    private void countDownControl(){
        seconds = 86400;
        isRunningOffer = true;

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;
                --seconds;
                if(isRunningOffer){
                    if(hours < 10)
                        textViewHour.setText("0"+Integer.toString(hours));
                    else
                        textViewHour.setText(Integer.toString(hours));
                    if(minutes < 10)
                        textViewMinute.setText("0"+Integer.toString(minutes));
                    else
                        textViewMinute.setText(Integer.toString(minutes));
                    if(sec < 10)
                        textViewSecond.setText("0"+Integer.toString(sec));
                    else
                        textViewSecond.setText(Integer.toString(sec));


                }
                handler.postDelayed(this, 1000);
                if(hours == 0 && minutes == 0 && seconds == 0){
                    textViewHour.setText("00");
                    textViewMinute.setText("00");
                    textViewSecond.setText("00");
                    isRunningOffer = false;
                    handler.removeCallbacks(this);
                }

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
