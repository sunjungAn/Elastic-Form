package com.example.hip;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    RecyclerView category_recyclerView, place_recyclerView;
    CategoryAdapter category_adapter;
    PlaceAdapter place_adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        // category RecyclerView
        category_recyclerView = findViewById(R.id.category);
        LinearLayoutManager category_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        category_recyclerView.setLayoutManager(category_layoutManager);
        category_adapter = new CategoryAdapter();
        category_recyclerView.setAdapter(category_adapter);

        // place RecyclerView
        place_recyclerView = findViewById(R.id.place);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        place_recyclerView.setLayoutManager(layoutManager);

        place_adapter = new PlaceAdapter();
        place_adapter.addItem(new Place("체부동", "국수"));
        place_adapter.addItem(new Place("레이어드", "카페"));
        place_adapter.addItem(new Place("수와래", "이탈리안"));
        place_adapter.addItem(new Place("라스위스", "양식"));
        place_recyclerView.setAdapter(place_adapter);

        place_adapter.setOnItemClickListener(new OnPlaceItemClickListener() {
            @Override
            public void onItemClick(PlaceAdapter.ViewHolder holder, View view, int position) {
                Place item = place_adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }




}