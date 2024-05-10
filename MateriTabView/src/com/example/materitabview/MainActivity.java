package com.example.materitabview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        // Tab untuk Menghitung Huruf
        Intent intent1 = new Intent(this, MenghitungHurufActivity.class);
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1")
                .setIndicator("Menghitung Huruf")
                .setContent(intent1);
        tabHost.addTab(tabSpec1);

        // Tab untuk Menghitung Kata
        Intent intent2 = new Intent(this, MeghitungKataActivity.class);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("Menghitung Kata")
                .setContent(intent2);
        tabHost.addTab(tabSpec2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
