package com.example.n09demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The third activity
 * <p>
 *     This activity demonstrate Configured Alert Dialog
 * </p>
 *
 * @author		Levy Albert albert.school2015@gmail.com
 * @version     2.0
 * @since		21/7/2023
 */
public class ThirdActivity extends AppCompatActivity {

    private LinearLayout linlay;
    private AlertDialog.Builder adb;
    private final String[] colors={"Red","Green","Blue"};
    private int[] color=new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        linlay = (LinearLayout) findViewById(R.id.linlay);
    }

    /**
     * btn1 method
     * <p> Demonstrate alert dialog with list in which only one item can be selected
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void btn1(View view) {

        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                linlay.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linlay.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * btn2 method
     * <p> Demonstrate alert dialog with list in which multi items can be selected
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void btn2(View view) {

        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("List of colors - multi choice");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which]=255;
                else if (color[which]==255) color[which]=0;
                linlay.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linlay.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * btn3 method
     * <p> Demonstrate alert dialog configured TextView widget
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void btn3(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("TextView Widget");
        final TextView tV=new TextView(this);
        adb.setView(tV);
        tV.setText("Just a message...");
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * oneButton method
     * <p> Demonstrate alert dialog configured EditText widget
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void btn4(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("EditText Widget");
        final EditText eT=new EditText(this);
        eT.setHint("Type text here");
        adb.setView(eT);
        adb.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eT.getText().toString();
                Toast.makeText(ThirdActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * onCreateOptionsMenu method
     * <p> Creating the options menu
     * </p>
     *
     * @param menu the Menu object to pass to the inflater
     * @return true
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * onOptionsItemSelected method
     * <p> Reacting the options menu
     * </p>
     *
     * @param item the MenuItem object that triggered by the listener
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemContext) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.itemAD) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (id == R.id.itemCAD) {
            Intent intent = new Intent(this, ForthActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}