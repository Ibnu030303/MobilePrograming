package com.example.materitabview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MeghitungKataActivity extends Activity implements View.OnClickListener {

    private EditText teksKataET;
    private TextView jumlahKataTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meghitung_kata);

        // Inisialisasi komponen UI
        teksKataET = (EditText) findViewById(R.id.teksKataEditText);
        jumlahKataTV = (TextView) findViewById(R.id.jumlahKataTextView);

        // Menambahkan onClickListener ke tombol hitung kata
        findViewById(R.id.hitungKataButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meghitung_kata, menu);
        return true;
    }

    public void onClick(View v) {
        // Memeriksa id komponen yang diklik
        switch (v.getId()) {
            case R.id.hitungKataButton:
                hitungKata();
                break;
        }
    }

    // Method untuk menghitung jumlah kata dalam teks yang dimasukkan
    private void hitungKata() {
        // Mendapatkan teks dari EditText
        String teks = teksKataET.getText().toString();
        // Inisialisasi variabel jumlah kata dan kata yang ditemukan
        int jumlahKata = 0;
        boolean kataDitemukan = false;

        // Iterasi setiap karakter dalam teks
        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);
            // Memeriksa apakah karakter adalah huruf
            if (Character.isLetter(karakter)) {
                kataDitemukan = true;
            } else {
                // Jika karakter bukan huruf dan kata sebelumnya ditemukan,
                // maka tambahkan jumlah kata dan setel kataDitemukan menjadi false
                if (kataDitemukan) {
                    jumlahKata++;
                    kataDitemukan = false;
                }
            }
        }

        // Menambahkan pengecekan untuk kata terakhir
        if (kataDitemukan) {
            jumlahKata++;
        }

        // Menetapkan jumlah kata ke TextView
        jumlahKataTV.setText(String.valueOf(jumlahKata));
    }
}
