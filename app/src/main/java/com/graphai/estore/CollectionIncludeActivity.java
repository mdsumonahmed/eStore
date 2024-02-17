package com.graphai.estore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CollectionIncludeActivity extends AppCompatActivity {

   /* RecyclerView recyclerView;
    CollectionChildAdapter adapter;
    List<CollectionChild>childList;*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_include);

       /* recyclerView = (RecyclerView)findViewById(R.id.include_recycler_view);
        childList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.iphonex));
        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.phone_5));
        childList.add(new CollectionChild("Top Spec Mobile","the best phone & tablet out there",R.drawable.phone_1,R.drawable.phone_5));

        adapter = new CollectionChildAdapter(this,childList);
        recyclerView.setAdapter(adapter);*/
    }
}
