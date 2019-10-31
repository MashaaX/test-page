package com.example.rizky.myintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);


        String nama = getIntent().getStringExtra("name");
        TextView txthsl = (TextView) findViewById(R.id.TxtIni);
        txthsl.setText("Hai "+nama );
    }
}
