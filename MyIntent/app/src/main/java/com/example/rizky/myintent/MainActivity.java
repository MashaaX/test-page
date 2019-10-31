package com.example.rizky.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickView (View v) {
        EditText edtTxtx = (EditText)findViewById(R.id.TextIni);
        String name = edtTxtx.getText().toString();
        Intent intent = new Intent(MainActivity.this,HasilActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
