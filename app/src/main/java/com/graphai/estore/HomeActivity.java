package com.graphai.estore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
//import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
//import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.INVISIBLE;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener, MessageFragment.OnFragmentInteractionListener, CartFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener {

    private ListView listView;
    private SearchView searchView;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private static final String TAG = "HomeActivity";

    // bottom navigation
    BottomNavigationView bottomNavigationView;
    /*Momin-----var ------start-----*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.my_drawer_id);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        /*ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.my_navigation_id);
        navigationView.setNavigationItemSelectedListener(this);
      //  navigationView.bringToFront();

        bottomNavigationView = findViewById(R.id.bottom_navigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout, new HomeFragment()).commit();
    }

    public static final String NAMES[] = {"Mridul", "Kazi", "Hello", "Mim"};

    private ArrayList doMySearch(String text){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < NAMES.length; i++){
            if((NAMES[i].toLowerCase()).startsWith(text)){
                result.add(NAMES[i]);
            }
        }
        return result;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    if(drawerLayout.isDrawerOpen(GravityCompat.START))
                        drawerLayout.closeDrawer(GravityCompat.START);

                    switch (menuItem.getItemId()){

                        case R.id.item_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.item_message:
                            selectedFragment = new MessageFragment();

                            break;

                        case R.id.icon_cart:
                            selectedFragment = new CartFragment();
                            break;

                        case R.id.icon_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,selectedFragment).commit();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_message_id,selectedFragment).commit();

                    return true;
                }
            };



    ////////////////////Navigation open control/////////////////////////////////////////
    /*|*/   @Override
    /*|*/    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        /*|*/        super.onPostCreate(savedInstanceState);
        /*|*/        drawerToggle.syncState();
        /*|*/    }
    /*|*/    @Override
    /*|*/    public void onConfigurationChanged(Configuration newConfig) {
        /*|*/        super.onConfigurationChanged(newConfig);
        /*|*/        drawerToggle.onConfigurationChanged(newConfig);
        /*|*/  }
    /*|*/
    /*|*/    ///// For Navigation item litener..
    /*|*/    @Override
    /*|*/    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        /*|*/        if(menuItem.getItemId() == R.id.setting_id){
            /*|*/            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
            /*|*/        }
        /*|*/
        /*|*/        if(menuItem.getItemId() == R.id.log_out){
            /*|*/            Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
            /*|*/        }
        /*|*/       if(menuItem.getItemId() == R.id.delevery_option){
            /*|*/            startActivity(new Intent(this, DeleveryActivity.class));
        }
        /*|*/        return false;
        /*|*/    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()){
            case R.id.local_grocery_store:
                startActivity(new Intent(this, CraftActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //instant search page and main page id
        final FrameLayout instantSearchPage = (FrameLayout)findViewById(R.id.instant_search_page);
        final LinearLayout mainPage = (LinearLayout)findViewById(R.id.main_page);

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView)searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                TextView imageView = (TextView) findViewById(R.id.result_no_found_message);

                if(s.length() > 0){
                    instantSearchPage.setVisibility(View.VISIBLE);
                    mainPage.setVisibility(INVISIBLE);
                    ArrayList<String> result = doMySearch(s.toLowerCase().trim());
                    ArrayAdapter<String> adpter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, result);
                    listView.setAdapter(adpter);
                    if(result.size()> 0){
                        imageView.setVisibility(INVISIBLE);
                        listView.setVisibility(View.VISIBLE);
                    }
                    else{
                        imageView.setVisibility(View.VISIBLE);
                        listView.setVisibility(INVISIBLE);
                    }
                }
                else{
                    instantSearchPage.setVisibility(INVISIBLE);
                    mainPage.setVisibility(View.VISIBLE);
                }

                return false;
            }
        });


        AdapterView.OnItemClickListener suggestionItemClickListener  = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView itemClicked = (TextView) view;
                String text = itemClicked.getText().toString();
                searchView.setQuery(text, true);
            }
        };

       // listView.setOnItemClickListener(suggestionItemClickListener);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        ComponentName componentName = new ComponentName(this, SearchableActivity.class);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
////////////////////////////////////////////////////////////////////////////
}
