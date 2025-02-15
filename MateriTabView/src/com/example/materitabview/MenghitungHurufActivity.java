package com.example.materitabview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenghitungHurufActivity extends Activity implements View.OnClickListener {

    EditText teksHurufET;
    TextView jumlahVokalTV, jumlahKonsonanTV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menghitung_huruf);

        teksHurufET = (EditText) findViewById(R.id.teksHurufEditText);
        jumlahVokalTV = (TextView) findViewById(R.id.jumlahVokalTextView);
        jumlahKonsonanTV = (TextView) findViewById(R.id.jumlahKonsonanTextView);

        findViewById(R.id.hitungHurufButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menghitung_huruf, menu);
        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hitungHurufButton:
                hitungHuruf();
                break;
        }
    }

    private void hitungHuruf() {
        String teks = teksHurufET.getText().toString();
        String[] listVokal = {"A", "E", "I", "O", "U"};
        int jumlahVokal = 0, jumlahKonsonan = 0;
        boolean vokal;

        for (int i = 0; i < teks.length(); i++) {
            char huruf = Character.toUpperCase(teks.charAt(i));
            if (Character.isLetter(huruf)) {
                vokal = false;
                for (String vokalHuruf : listVokal) {
                    if (String.valueOf(huruf).equals(vokalHuruf)) {
                        vokal = true;
                        break;
                    }
                }
                if (vokal) {
                    jumlahVokal++;
                } else {
                    jumlahKonsonan++;
                }
            }
        }

        jumlahVokalTV.setText(String.valueOf(jumlahVokal));
        jumlahKonsonanTV.setText(String.valueOf(jumlahKonsonan));
    }
}
