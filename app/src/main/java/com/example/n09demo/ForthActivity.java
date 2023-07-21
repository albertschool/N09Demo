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
import android.widget.Toast;

/**
 * The forth activity
 * <p>
 *     This activity demonstrate Custom Alert Dialog
 * </p>
 *
 * @author		Levy Albert albert.school2015@gmail.com
 * @version     2.0
 * @since		21/7/2023
 */
public class ForthActivity extends AppCompatActivity {

    private AlertDialog.Builder adb;
    private LinearLayout mydialog;
    private EditText eTName, eTPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
    }

    /**
     * start method
     * <p> Demonstrate custom alert dialog from the my_dialog layout
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void start(View view) {
        mydialog=(LinearLayout) getLayoutInflater().inflate(R.layout.my_dialog,null);
        eTName = (EditText) mydialog.findViewById(R.id.eTname);
        eTPass = (EditText) mydialog.findViewById(R.id.eTpass);

        adb=new AlertDialog.Builder(this);

        adb.setView(mydialog);
        mydialog.setBackgroundColor(Color.YELLOW);
        adb.setTitle("Identification");
        adb.setMessage("Please enter your name & password:");
        adb.setPositiveButton("Enter",myclick);
        adb.setNegativeButton("Cancel",myclick);
        adb.show();
    }

    /**
     * onClick method of the dialog
     * <p> Demonstrate custom alert dialog from the my_dialog layout
     * </p>
     *
     * @param dialog the DialogInterface object that triggered the method
     * @param which the identifier that clicked
     */
    DialogInterface.OnClickListener myclick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                String str1 = eTName.getText().toString();
                String str2 = eTPass.getText().toString();
                Toast.makeText(ForthActivity.this, "Name: "+str1+" Password: "+str2, Toast.LENGTH_SHORT).show();
            }
            if (which == DialogInterface.BUTTON_NEGATIVE) {
                dialog.cancel();
            }
        }
    };

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
        } else if (id == R.id.itemCD) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}