package com.example.melg.moviedbapp;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.navigationView)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.framelayout)
    FrameLayout customView;




    FavoritesView favoritesView;
    private View homeView;

    @Override
    protected void onStart() {
        super.onStart();

        LayoutInflater layoutInflater = getLayoutInflater();
        homeView = layoutInflater.inflate(R.layout.home_view, null);



        customView.addView(homeView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavi);


    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavi = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.home:
                    customView.removeAllViews();
                    customView.addView(homeView);
                    return true;
                case R.id.Fav:
                    customView.removeAllViews();
                    FavoritesView favoritesView = new FavoritesView(MainActivity.this);
                    customView.addView(favoritesView);
                    return true;
            }
            return false;
        }
    };
}

