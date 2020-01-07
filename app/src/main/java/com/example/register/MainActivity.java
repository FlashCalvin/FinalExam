package com.example.register;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean isNext = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Switch sw = findViewById(R.id.change);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView txt = findViewById(R.id.regist);
                if(!isChecked){
                    txt.setText("Login");
                }else
                    txt.setText("Regist");

            }
        });
        //
        String userName = getSharedPreferences("test",MODE_PRIVATE)
                .getString("NAME","");
        EditText name = findViewById(R.id.name);
        name.setText(userName);
        //
        String userAccount = getSharedPreferences("test",MODE_PRIVATE)
                .getString("ACCOUNT","");
        EditText account = findViewById(R.id.user_account);
        account.setText(userAccount);
        //
        String userPassword = getSharedPreferences("test",MODE_PRIVATE)
                .getString("PASSWORD","");
        EditText password = findViewById(R.id.user_password);
        password.setText(userPassword);

    }
    public void Register (View view){
        Intent intent  = new Intent(MainActivity.this,NameActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
