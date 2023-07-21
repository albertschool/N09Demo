package com.example.n09demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * The main activity
 * <p>
 * A basic demo application to demonstrate:
 * 1. options menu
 * 2. context menu
 * 3. Alert Dialog
 * 4. Configured Alert Dialog
 * 5. Custom Alert Dialog
 * <p>
 * This activity demonstrate context menu & include options menu
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 21 /7/2023
 */
public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {

    private LinearLayout linlay;
    private ImageView iV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linlay = findViewById(R.id.linlay);
        iV = findViewById(R.id.iV);

        iV.setOnCreateContextMenuListener(this);
    }

    /**
     * onCreateContextMenu method
     * <p> Creating the context menu
     * </p>
     *
     * @param menu the ContextMenu object to pass to the listener
     * @param view the View object to pass to the listener
     * @param menuInfo the View object to pass to the listener
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Color Options");
        menu.add("Red");
        menu.add("Green");
        menu.add("Blue");
        menu.add("White");
    }

    /**
     * onContextItemSelected method
     * <p> Reacting the context menu
     * </p>
     *
     * @param item the MenuItem object that triggered by the listener
     * @return super.onContextItemSelected(item)
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String color = item.getTitle().toString();
        if (color.equals("Red")) {
            linlay.setBackgroundColor(Color.RED);
        } else if (color.equals("Green")) {
            linlay.setBackgroundColor(Color.GREEN);
        } else if (color.equals("Blue")) {
            linlay.setBackgroundColor(Color.BLUE);
        } else {
            linlay.setBackgroundColor(Color.WHITE);
        }
        return super.onContextItemSelected(item);
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
        if (id == R.id.itemAD) {
            Intent intent = new Intent(this, SecondActivity.class);
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