package com.graphai.estore;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private Context mContext;
    RecyclerView recyclerView;
    FCartProductAdapter adapter;
    List<FCartProduct> craftProductList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view=inflater.inflate( R.layout.fragment_cart, container, false);
        craftProductList = new ArrayList<>();
        recyclerView =(RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartFragment.this.getContext()));


        craftProductList.add(
                new FCartProduct(
                        1,
                        "MULTIFUNCTION EXPANDABLE MAGI...",
                        "Master Kitchen, Color Family : Green",
                        6500.00,R.drawable.macbook));
        craftProductList.add(
                new FCartProduct(
                        1,
                        "CURREN 8083 Silver Stainless Steel Chr....",
                        "CURREN Watch strap Color : Silver",
                        6500.00,R.drawable.macbook));
        craftProductList.add(
                new FCartProduct(
                        1,
                        "Double Part # in ! inflatable Travelling Pi...",
                        "Wall Touch Color Family : Light Green",
                        6500.00,R.drawable.macbook));
        craftProductList.add(
                new FCartProduct(
                        1,
                        "Double Part # in ! inflatable Travelling Pi...",
                        "Wall Touch Color Family : Light Green",
                        6500.00,R.drawable.macbook));

        adapter = new FCartProductAdapter(mContext, craftProductList);
        recyclerView.setAdapter(adapter);
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
