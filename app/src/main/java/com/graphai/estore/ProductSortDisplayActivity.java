package com.graphai.estore;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductSortDisplayActivity extends AppCompatActivity {

    private ImageButton viewBy;

    List<ProductModel> productList;
    ProductAdapter productAdapter;

    ArrayList<Integer> productImage = new ArrayList<Integer>(Arrays.asList(R.drawable.phone_1, R.drawable.phone_2,R.drawable.phone_3,R.drawable.phone_4,R.drawable.phone_5,R.drawable.phone_6,R.drawable.phone_7,R.drawable.phone_8));
    ArrayList<String> productName = new ArrayList<String>(Arrays.asList("Symphony P7","Redmi Note 6 Pro","Samsung J7 Nxt","Walton Primo GF","Symphony P7","Redmi Note 6 Pro","Samsung J7 Nxt","Walton Primo GF"));
    ArrayList<Integer> productPrice = new ArrayList<Integer>(Arrays.asList(10000,80000,60000,30000,100000,20000,50000,40000));
    ArrayList<Float> productRating = new ArrayList<Float>(Arrays.asList(4.5f,3.4f,4.1f,2.9f,4.9f,3.4f,4.5f,4.8f));

    ArrayList<ProductModel> productItem;

    boolean isListView=true;
    int shortBY=0;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sort_display);

        final RecyclerView recyclerView = findViewById(R.id.product_list);
        Spinner spinner = findViewById(R.id.sort_by);
        viewBy = findViewById(R.id.view_by);

        //Spinner
        ArrayAdapter myAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.sort_by_array));
        spinner.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shortBY=position;
                shortProductItem();
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //RecyclerView
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this,productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(productAdapter);

        viewBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isListView) {
                    viewBy.setImageResource(R.drawable.ic_view_module_black_24dp);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProductSortDisplayActivity.this, LinearLayoutManager.VERTICAL,false));
                }else{
                    viewBy.setImageResource(R.drawable.ic_list);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(staggeredGridLayoutManager);
                }
                isListView = !isListView;
                addProductItem();
            }
        });

        addProductItem();

        TextView productFound = ((TextView)findViewById(R.id.product_found));
        productFound.setText(String.valueOf(productName.size()));

    }

    private void shortProductItem() {
        if (shortBY == 0)
            Collections.sort(productList, ProductModel.productRatingComparator);
        else if (shortBY == 1)
            Collections.sort(productList, ProductModel.productPriceComparatorAscending);
        else if (shortBY == 2)
            Collections.sort(productList, ProductModel.productPriceComparatorDescending);
    }

    private void addProductItem(){
        String whatView;
        if(isListView) whatView="list";
        else whatView="grid";
        //Products
        productItem = new ArrayList<>();
        productItem.clear();

        for(int i = 0; i < productName.size(); i++) {
            productItem.add(new ProductModel(productImage.get(i),productName.get(i),productPrice.get(i),productRating.get(i),whatView));
        }

        productList.clear();
        productList.addAll(productItem);
        shortProductItem();
        productAdapter.notifyDataSetChanged();
    }
}
