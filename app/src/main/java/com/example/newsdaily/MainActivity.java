package com.example.newsdaily;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private android.support.v4.app.Fragment frag1,frag2,frag3;
    Bundle bundle = new Bundle();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_url:
                    bundle.putString("params","https://newsapi.org/v2/everything?sources=abc-news&apiKey=e73a2ba82dde410ba3de46c358f7d527");
                    frag1.setArguments(bundle);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_fragmentholder, frag1)
                            .commit();

                    return true;
                case R.id.navigation_qrcode:
                    bundle.putString("params","https://newsapi.org/v2/everything?sources=the-times-of-india&apiKey=e73a2ba82dde410ba3de46c358f7d527");
                    frag2.setArguments(bundle);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_fragmentholder, frag2)
                            .commit();

                    return true;
                case R.id.navigation_ocr:
                    bundle.putString("params","https://newsapi.org/v2/everything?sources=techcrunch&apiKey=e73a2ba82dde410ba3de46c358f7d527");
                    frag3.setArguments(bundle);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_fragmentholder, frag3)
                            .commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        frag1 = new NewsFragment();
        frag2 = new NewsFragment();
        frag3 = new NewsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, frag1)
                .commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
