package com.example.ex101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

/**
 *  * @author		Shahar Yani
 *  * @version  	1.3
 *  * @since		12/11/2020
 *
 *  * This MainActivity.class displays 5 different types of alertDialog view object
 *    and a menu to Credits.class
 *  */
public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    /**
     * The Adb is binding all the features of an alertDialog.
     */
    AlertDialog.Builder adb;
    /**
     * The Layout is the screen layout of the activity.
     */
    LinearLayout layoutScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutScreen = findViewById(R.id.layoutScreen);
    }

    /**
     * First selected works when it selected and displays an alertDialog object
     * with a message
     *
     * @param view the view
     */
    public void firstSelected(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("First Dialog");
        adb.setMessage("A message");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Second selected works when it selected and displays an alertDialog object
     * with a message and an icon.
     *
     * @param view the view
     */
    public void secondSelected(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Second Dialog");
        adb.setMessage("A message with an icon");
        adb.setIcon(R.mipmap.ic_launcher);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Third selected works when it selected and displays an alertDialog object
     * with A message with an icon and back opption.
     *
     * @param view the view
     */
    public void thirdSelected(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Third Dialog");
        adb.setMessage("A message with an icon and back");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setNeutralButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Fourth selected works when it selected and displays an alertDialog object
     * with Generates random colors and display those on the main LinearLayout of the activity.
     *
     * @param view the view
     */
    public void fourthSelected(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Fourth Dialog");
        adb.setMessage("Generates random colors");
        adb.setPositiveButton("RAND COLORS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random rnd = new Random();
                int r = rnd.nextInt()*256;
                int g = rnd.nextInt()*256;
                int b = rnd.nextInt()*256;
                layoutScreen.setBackgroundColor(Color.rgb(r,g,b));
            }
        });
        adb.setNeutralButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * First selected works when it selected and displays an alertDialog object
     * with the features that appreas in the previous methond and a reset opption to white.
     *
     * @param view the view
     */
    public void fifthSelected(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Fifth Dialog");
        adb.setMessage("Generates random colors to display and clear");
        adb.setPositiveButton("RAND COLORS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random rnd = new Random();
                int r = rnd.nextInt()*256;
                int g = rnd.nextInt()*256;
                int b = rnd.nextInt()*256;
                layoutScreen.setBackgroundColor(Color.rgb(r,g,b));
            }
        });
        adb.setNegativeButton("CLEAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layoutScreen.setBackgroundResource(R.color.white);
            }
        });
        adb.setNeutralButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) { }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Credits");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str = item.toString();
        if (str.equals("Credits")){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}