package com.example.dcucharo.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_Display);

        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo(View view) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("user",etUsername.getText().toString());
        editor.putString("pwd",etPassword.getText().toString());
        editor.commit();

        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
    }
    public void loadInfo(View view) {
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd","");
        tvDisplay.setText("User is " + user + " and the Password is " + password);

    }
}
