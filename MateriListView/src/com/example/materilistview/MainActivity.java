package com.example.materilistview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private java.util.ArrayList<String> items = new java.util.ArrayList<String>();
    private ListView mataKuliahListView;
    private String[] listMataKuliah = {"Algorithma Pemrograman I","Algorithma Pemrograman II","Struktur Data I","Struktur Data II","Mobile Programming","Pemrograman I","Pemrograman II","Bahasa Indonesia","Agama","PKN","Bahasa Inggris","Basis Data I","Basis Data II","Kalkulus","Aljabar Linier","Matematika Diskrit","Fisika","Etika Profesi"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < listMataKuliah.length; i++) {
            items.add(listMataKuliah[i]);
        }

        mataKuliahListView = (ListView) findViewById(R.id.mataKuliahListView);
        mataKuliahListView.setOnItemClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        mataKuliahListView.setAdapter(adapter);

        findViewById(R.id.xButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(this, DipilihActivity.class);
        intent.putExtra("mataKuliah", items.get(arg2));
        startActivity(intent);
    }

    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Informasi");
        alert.setMessage("Mata kuliah " + items.get(arg2));
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Tombol Ya di klik", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Tombol Tidak di klik", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
        return false;
    }
}
