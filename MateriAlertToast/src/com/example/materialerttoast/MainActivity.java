package com.example.materialerttoast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private String[] items = {"Short", "Long"};
    private Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.durasiSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        spinner.setAdapter(adapter);

        findViewById(R.id.alert1Button).setOnClickListener(this);
        findViewById(R.id.alert2Button).setOnClickListener(this);
        findViewById(R.id.alert3Button).setOnClickListener(this);
        findViewById(R.id.toastButton).setOnClickListener(this);
        findViewById(R.id.tutupButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alert1Button:
                AlertDialog alert1 = new AlertDialog.Builder(this).create();
                alert1.setTitle("Notifikasi");
                alert1.setMessage("Tampilan Alert 1");
                alert1.setIcon(R.drawable.ic_launcher);
                alert1.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Ok diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert1.show();
                break;
            case R.id.alert2Button:
                AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
                alert2.setTitle("Konfirmasi");
                alert2.setMessage("Tampilan Alert 2, klik tombol");
                alert2.setIcon(R.drawable.ic_launcher);
                alert2.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Ya diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert2.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Tidak diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert2.show();
                break;
            case R.id.alert3Button:
                AlertDialog.Builder alert3 = new AlertDialog.Builder(this);
                alert3.setTitle("Konfirmasi");
                alert3.setMessage("Tampilan Alert 3, klik tombol");
                alert3.setIcon(R.drawable.ic_launcher);
                alert3.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Ya diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert3.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Tidak diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert3.setNeutralButton("Batal", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(),
                                "Tombol Batal diklik", Toast.LENGTH_SHORT).show();
                    }
                });
                alert3.show();
                break;
            case R.id.toastButton:
                if (spinner.getSelectedItemPosition() == 0) {
                    Toast.makeText(this, "Toast Short", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Toast Long", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.tutupButton:
                finish();
                break;
        }
    }
}
