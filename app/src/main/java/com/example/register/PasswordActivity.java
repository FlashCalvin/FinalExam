package com.example.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edPassword = findViewById(R.id.user_password);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public  void  commitb(View view) {
        String stringPassword = edPassword.getText().toString();
        if (!TextUtils.isEmpty(stringPassword)) {
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Must enter something")
                    .setPositiveButton("OK",null)
                    .show();
        } else {
            Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
            String userpassword = edPassword.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("PASSWORD", userpassword)
                    .commit();
            startActivity(intent);
        }
    }

}
