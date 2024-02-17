package com.graphai.estore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HelpContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout search = findViewById(R.id.search_id);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpContactActivity.this, "SEARCH Click", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout browseHelp = findViewById(R.id.browse_help_id);

        browseHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpContactActivity.this, "BROWSE HELP CENTER Click", Toast.LENGTH_SHORT).show();
            }
        });

        TextView here1 = findViewById(R.id.textview_here_id1);

        here1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpContactActivity.this, "Here Clickable", Toast.LENGTH_SHORT).show();
            }
        });

        TextView here2 = findViewById(R.id.textview_here_id2);

        here2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelpContactActivity.this, "Here Clickable", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
