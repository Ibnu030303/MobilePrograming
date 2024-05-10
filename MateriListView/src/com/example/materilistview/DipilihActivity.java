package com.example.materilistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DipilihActivity extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dipilih);
        
        TextView mataKuliahTV = (TextView) findViewById(R.id.mataKuliahTextView);
        String mataKuliah = getIntent().getStringExtra("mataKuliah");
        mataKuliahTV.setText(mataKuliah);

        findViewById(R.id.kembaliButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dipilih, menu);
        return true;
    }
    
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.kembaliButton:
                finish();
                break;
        }
    }
}
