package com.graphai.estore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetClass extends BottomSheetDialogFragment {

    private ImageButton closeButton;
    private Button cancleButton;
    RecyclerView recyclerView;
    BottomSheetRecyclerAdapter adapter;
    List<Bottomsheet_recycler_design_child> bottomSheetProductList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout,container,false);


        closeButton = v.findViewById(R.id.image_button_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        cancleButton = v.findViewById(R.id.cancle_button);
        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        recyclerView = v.findViewById(R.id.recycler_view);
        bottomSheetProductList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));
        bottomSheetProductList.add(new Bottomsheet_recycler_design_child(R.drawable.chicken,"Chicken","Southern fried chicken, also known simply as fried chicken,","400 tk"));

        adapter = new BottomSheetRecyclerAdapter(getContext(),bottomSheetProductList);
        recyclerView.setAdapter(adapter);


        return v;
    }
}