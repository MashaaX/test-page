package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText txtName;
    EditText txtEmail;

    private final String mypref = "mypref";
    private final String pref_name = "name";
    private final String pref_email = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(mypref,MODE_PRIVATE);
        txtName = findViewById(R.id.editTextNAME);
        txtEmail = findViewById(R.id.editTextEMAIL);
    }

    public void btnSAVE(View view) {
        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(pref_name, name);
        editor.putString(pref_email, email);
        editor.apply();
    }

    public void btnRETR(View view) {
        String name = sharedPreferences.getString(pref_name, "Rizky Budiman");
        String email = sharedPreferences.getString(pref_email, "daedalus28id@gmail.com");
        txtName.setText(name);
        txtEmail.setText(email);
    }

    public void btnCLEAR(View view) {
        txtName.getText().clear();
        txtEmail.getText().clear();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
