package com.example.ex101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 *  * @author		Shahar Yani
 *  * @version  	1.1
 *  * @since		12/11/2020
 *
 *  * This Credits.class displays a credit activity
 *    and a menu to return to MainActivity.class
 *  */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Back");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str = item.toString();
        if (str.equals("Back")){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}