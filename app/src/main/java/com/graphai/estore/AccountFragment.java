package com.graphai.estore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AccountFragment extends Fragment {

    ImageView settingImageButton;
    private OnFragmentInteractionListener mListener;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        TextView txt = (TextView) view.findViewById(R.id.view_all_id);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*startActivity(new Intent(MainActivity.this,ViewActivity.class));*/
                Intent intent = new Intent(mContext,ViewActivity.class);
                startActivity(intent);
            }
        });

        ImageView pay = view.findViewById(R.id.pay_id);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Pay Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView review = view.findViewById(R.id.review_id);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Review Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView returnId = view.findViewById(R.id.return_id);

        returnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Return Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView cancel = view.findViewById(R.id.cancel_id);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Cancel Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView message = view.findViewById(R.id.message_id);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Message Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView reviewId = view.findViewById(R.id.my_review_id);

        reviewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "My Review Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView payment = view.findViewById(R.id.payment_id);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Payment Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView help = view.findViewById(R.id.help_id);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Help Click", Toast.LENGTH_SHORT).show();
            }
        });

        settingImageButton = view.findViewById(R.id.setting_image_button);
        settingImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AccountSetting.class);
                startActivity(intent);
            }
        });
        return view;
    }

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
        void onFragmentInteraction(Uri uri);
    }
}
