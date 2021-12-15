package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguide.Common.LoginSignUp.RetailerStartUpScreen;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, categoriesRecycler, mostViewedRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        categoriesRecycler = findViewById(R.id.category_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();


        //Recycler views function calls
        featuredRecycler();
        categoriesRecycler();
        mostViewedRecycler();
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();


    }

    //Animate NavigationDrawer
    private void animateNavigationDrawer() {

        // drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                //Scale the view based on current slide offset
                final float diffScaledOffSet = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffSet;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translate the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffSet / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


    //Recycler views functions
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding2, "McDonald's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding, "Michelle;s", "miacadadf couadodf adokfmie afadcaidac adfafdacdc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding2, "Danillo", "adniadfa danilio adfadicda afadcaidac adfafdacdc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding2, "Danillo", "adniadfa danilio adfadicda afadcaidac adfafdacdc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding2, "Danillo", "adniadfa danilio adfadicda afadcaidac adfafdacdc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.onboarding2, "Danillo", "adniadfa danilio adfadicda afadcaidac adfafdacdc"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
        // GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void categoriesRecycler() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesLocations = new ArrayList<>();

        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding2, "McDonalds"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding, "Michelle"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding, "Michelle"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding, "Michelle"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding, "Michelle"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.onboarding, "Michelle"));

        adapter = new CategoriesAdapter(categoriesLocations);
        categoriesRecycler.setAdapter(adapter);


    /*  gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});*/
        // categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.school_image, "Education"));

    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "McDonald's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding, "Michelle's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "Justine's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "Justine's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "Justine's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "Justine's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.onboarding2, "Justine's", "miacadadf afdafdaficad afadfdacad afadcaidac adfafdacdc"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    //Normal Functions

    public void callRetailerScreens(View view) {
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }


}
