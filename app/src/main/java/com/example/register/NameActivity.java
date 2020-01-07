package com.example.register;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText edName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edName = findViewById(R.id.username);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void commit(View view){
        String nameString = edName.getText().toString();
        if(!TextUtils.isEmpty(nameString)){
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Must enter something")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            Intent intent = new Intent(NameActivity.this, AccountActivity.class);
            String username = edName.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("NAME", username)
                    .commit();
            startActivity(intent);
        }

    }

}
