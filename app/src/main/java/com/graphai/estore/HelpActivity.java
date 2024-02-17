package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<TopQuestion> questionList = new ArrayList<>();
        questionList.add(new TopQuestion("How can I track my order?"));
        questionList.add(new TopQuestion("How do I pay with my Debit/Credit Card?"));
        questionList.add(new TopQuestion("How to Return a Product?"));
        questionList.add(new TopQuestion("How to place an order on 'Daraz'?"));
        questionList.add(new TopQuestion("How to make b-Kash Payment on Daraz?"));
        questionList.add(new TopQuestion("How to save your card on Daraz APP?"));
        questionList.add(new TopQuestion("How to Top-Up on Daraz?"));
        questionList.add(new TopQuestion("What is DarazMall?"));

        RecyclerView recyclerView = findViewById(R.id.top_question_id);
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        TopQuestionAdapter questionAdapter = new TopQuestionAdapter(this,questionList);
        recyclerView.setAdapter(questionAdapter);

        Button chat = findViewById(R.id.button_chat_id);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "CHAT NOW Click", Toast.LENGTH_SHORT).show();
            }
        });

        Button option = findViewById(R.id.button_other_option_id);

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "OTHER OPTION Click", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView like = findViewById(R.id.image_like_id);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "Like Enable", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView disLike = findViewById(R.id.image_dislike_id);

        disLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "Dislike Enable", Toast.LENGTH_SHORT).show();
            }
        });

        TextView help = findViewById(R.id.help_center_id);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "Help Center Click", Toast.LENGTH_SHORT).show();
            }
        });

        TextView privacy = findViewById(R.id.privacy_policy_id);

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "Privacy Policy Click", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tc = findViewById(R.id.t_c_id);

        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "T and Cs CLick", Toast.LENGTH_SHORT).show();
            }
        });

        TextView contact = findViewById(R.id.contact_us_id);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this,HelpContactActivity.class);
                startActivity(intent);
            }
        });

        TextView sell = findViewById(R.id.sell_daraz_id);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpActivity.this, "Sell On Daraz Click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
