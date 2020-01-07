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

public class AccountActivity extends AppCompatActivity {

    private EditText edAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edAccount = findViewById(R.id.user_account);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void commita(View view){
        String AccountString = edAccount.getText().toString();
        if(!TextUtils.isEmpty(AccountString)){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Must enter somrthing")
                    .setPositiveButton("ok",null)
                    .show();
        }else {
            Intent intent = new Intent(AccountActivity.this, PasswordActivity.class);
            String useraccount = edAccount.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("ACCOUNT", useraccount)
                    .commit();
            startActivity(intent);
        }
    }
}
