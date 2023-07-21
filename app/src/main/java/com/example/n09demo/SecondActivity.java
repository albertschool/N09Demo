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
import android.widget.LinearLayout;

/**
 * The second activity
 * <p>
 *     This activity demonstrate Configured Alert Dialog
 * </p>
 *
 * @author		Levy Albert albert.school2015@gmail.com
 * @version     2.0
 * @since		21/7/2023
 */
public class SecondActivity extends AppCompatActivity {

    private LinearLayout linlay;
    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linlay = (LinearLayout) findViewById(R.id.linlay);
    }

    /**
     * noButton method
     * <p> Demonstrate alert dialog with no buttons
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void noButton(View view) {
        adb=new AlertDialog.Builder(this);

        adb.setTitle("1st Example: Text only");
        adb.setMessage("This is a simple alert");

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * noButtonIcon method
     * <p> Demonstrate alert dialog with icon & no buttons
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void noButtonIcon(View view) {
        adb=new AlertDialog.Builder(this);

        adb.setTitle("2nd Example: Icon & Text only");
        adb.setMessage("This is a simple alert");
        adb.setIcon(R.drawable.droid);

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * oneButton method
     * <p> Demonstrate alert dialog with one button
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void oneButton(View view) {
        adb=new AlertDialog.Builder(this);

        adb.setTitle("3rd Example: One button only");
        adb.setMessage("This is a simple alert");
        adb.setIcon(R.drawable.droid);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * twoButtons method
     * <p> Demonstrate alert dialog with two buttons
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void twoButtons(View view) {
        adb=new AlertDialog.Builder(this);

        adb.setTitle("4th Example: Two buttons");
        adb.setMessage("Choose 2 options:");
        adb.setIcon(R.drawable.droid);
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linlay.setBackgroundColor(Color.GREEN);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * threeButtons method
     * <p> Demonstrate alert dialog with three buttons
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void threeButtons(View view) {
        adb=new AlertDialog.Builder(this);

        adb.setTitle("5th Example: Three buttons");
        adb.setMessage("Choose 3 options:");
        adb.setIcon(R.drawable.droid);
        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linlay.setBackgroundColor(Color.RED);
            }
        });
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linlay.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
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
        } else if (id == R.id.itemCD) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        } else if (id == R.id.itemCAD) {
            Intent intent = new Intent(this, ForthActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}