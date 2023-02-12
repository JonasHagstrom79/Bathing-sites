package se.miun.caha1906.dt031g.bathingsites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Constants used as a key to store or identify
    public static final String TAG_FRAGMENT_BATHING_SITES = "fragment_bathing_sites";
    private static final String KEY_COUNT_VALUE = "Countvalue";
    private static final String KEY_BATHSITES_TEXT = "bathingSitesText";

    // Stores the count value
    private int count =0;

    // TextView for toast message
    TextView countertextView;

    // Floating action button
    FloatingActionButton fab;

    // For the view
    BathingSitesView bathingSitesView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView((R.layout.activity_main));

        // Get the views
        findViews();

        // Start a new fragment transaction, https://developer.android.com/guide/fragments
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Create a new instance of the bathing sites fragment
        BathingSitesFragment bathingSitesFragment = new BathingSitesFragment();

        // Replace the current fragment in the container with the newly created bathing sites fragment
        transaction.replace(R.id.fragment_container, bathingSitesFragment, TAG_FRAGMENT_BATHING_SITES);

        // Add the current transaction to the backstack, allowing the user to navigate back to the previous fragment
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

        // Sets click listener on the button
        fab.setOnClickListener(view -> {

            // Creates an intent to start the AddBathingSiteActivity class
            Intent intent = new Intent(MainActivity.this, AddBathingSiteActivity.class);

            // Starts the activity specified in the intent
            startActivity(intent);

        });

        // Saved instance state
        if (savedInstanceState != null) {

            count = savedInstanceState.getInt(KEY_COUNT_VALUE, count);

            countertextView.setText(count + " " + getString(R.string.bathingSitesText));

        }

    }

    /**
     * Creates the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflates the main_menu layout into the menu object
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Returns true to indicate that the menu was created successfully
        return true;

    }

    /**
     * Saves the state
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        // Call the superclass's implementation of onSaveInstanceState()
        super.onSaveInstanceState(outState);

        // Save the value of the count variable
        outState.putInt("Countvalue", count);

        // Concatenate the count value with the string from the string resource file
        String bathingSitesText = count + getString(R.string.BathingSitesViewCounterText);

        // Put the string into the outState bundle with a key for later retrieval
        outState.putString(KEY_BATHSITES_TEXT, bathingSitesText);

    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Get the saved value for count and set it to the count variable
        count = savedInstanceState.getInt("Countvalue");

        // Get the saved value for the bathing sites text
        String bathingSitesText = savedInstanceState.getString(KEY_BATHSITES_TEXT);

        // Get the textview object
        TextView textView = findViewById(R.id.textViewBathingSitesView);

        // Set the text for the view
        textView.setText(bathingSitesText);
    }


    /**
     * Adds +1 on counter in bathingsitesView
     */
    public void incrementBathingSitesCount() {

        // Adds one to count
        count++;

        // Get the view
        countertextView = findViewById(R.id.textViewBathingSitesView);

        // Set the text for the view
        countertextView.setText(String.valueOf(count + getString(R.string.BathingSitesViewCounterText)));

    }

    /**
     * Get the views
     */
    private void findViews() {

        fab = findViewById(R.id.floatingActionButton2);

        bathingSitesView = findViewById(R.id.bathing_site_view);

        countertextView = findViewById(R.id.textViewBathingSitesView);

    }



}