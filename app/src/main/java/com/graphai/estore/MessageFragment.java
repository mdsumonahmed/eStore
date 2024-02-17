package com.graphai.estore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    private Context mContext;
    private Intent intent;
    private ImageButton orderButton,notificationButton,promoButton;
    RecyclerView recyclerView;
    FMessageAdapter adapter;
    List<FMessageProduct> fMessageProductList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MessageFragment() {

    }

    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_message, container,false);
        // Inflate the layout for this fragment

        Toast.makeText(mContext, "Message", Toast.LENGTH_SHORT).show();
        orderButton = (ImageButton)view.findViewById(R.id.order_button);
        notificationButton = (ImageButton)view.findViewById(R.id.notification_button);
        promoButton = (ImageButton)view.findViewById(R.id.promo_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent=new Intent(MessageFragment.this.getActivity(),OrderActivity.class));
            }
        });
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent=new Intent(MessageFragment.this.getActivity(),NotificationActivity.class));
            }
        });
        promoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent = new Intent(MessageFragment.this.getActivity(),PromoActivity.class));
            }
        });

        fMessageProductList = new ArrayList<>();



        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.iphonex));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_2));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_3));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_4));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.iphonex));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        fMessageProductList.add(new FMessageProduct("Mobile Sell Off","Samsung Exynos Octa-Core Processor (1.6GHz),16GB Internal Memory + Install Apps to Memory Card,Long Lasting Battery (2,600mAh)",R.drawable.phone_6));
        adapter = new FMessageAdapter(mContext,fMessageProductList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

         mContext = context;
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
