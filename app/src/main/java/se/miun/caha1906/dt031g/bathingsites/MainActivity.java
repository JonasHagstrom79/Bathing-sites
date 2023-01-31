package se.miun.caha1906.dt031g.bathingsites;

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

    //FloatingActionButton fab; //TODO:2023-01-10
    BathingSitesView bathingSiteView;

    private static final String TAG_FRAGMENT_BATHING_SITES = "fragment_bathing_sites"; //TODO:new!

    // Edittext from fragment
    EditText name, description, address, longitude, latitude, waterTemp, dateForTemp;

    // Ratingbar from fragment
    RatingBar grade;

    // Todays date
    String todaysDateFormatted, nameCheck, addressCheck, longitudeCheck, latitudeCheck;

    // To set todays date
    Calendar calendar;

    // Formatting the date from calendar
    SimpleDateFormat dateFormat;

    // TextView for toast message
    TextView toastName, toastDescription, toastAddress, toastLongitude,
            toastLatitude, toastGrade, toastWaterTemp, toastDateForTemp;

    // Toast
    Toast toast;

    // View
    View view;

    // Floating action button
    FloatingActionButton fab;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //savedInstanceState.putInt(); //TODO:här!!!!
        super.onCreate(savedInstanceState);

        setContentView((R.layout.activity_main));

        // Get the views
        findViews();

        // Start a new fragment transaction
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

    }

    // Gets the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflates the main_menu layout into the menu object
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Returns true to indicate that the menu was created successfully
        return true;

    }

    // Handle Clear and save
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        // Clear the input
//        if (item.getItemId() == R.id.action_clear) {
//
//            // Get the views
//            findViews();
//
//            // Clear the inputfields and set todays date
//            clearInputFields();
//            setTodaysDate();
//
//            return true;
//        }
//
//        // Saves the input
//        if (item.getItemId() == R.id.action_save) {
//
//            if (nameIsEmpty()) {
//
//                // Displays error messgage from method
//
//            }
//            if (addressLongLatIsEmpty()) {
//
//                // Displays error message
//
//            }else {
//
//                showToast();
//
//            }
//
//            return true;
//
//        }
//
//        //
//        return super.onOptionsItemSelected(item);
//
//    }

    /**
     * Get the views
     */
    private void findViews() {

        fab = findViewById(R.id.floatingActionButton2);
//
//        // Inflates the view for the toast message //TODO:really here?
//        view = LayoutInflater.from(MainActivity.this)
//                .inflate(R.layout.toast_layout, null);
//
//        // Edit text
//        name = findViewById(R.id.editTextTextBathingSiteName);
//        description = findViewById(R.id.editTextTextBathigSiteDescription);
//        address = findViewById(R.id.editTextTextBathingSiteAddress);
//        longitude = findViewById(R.id.editTextTextBathingSiteLongitude);
//        latitude = findViewById(R.id.editTextTextBathingSiteLatitude);
//        grade = findViewById(R.id.ratingBar);
//        waterTemp = findViewById(R.id.editTextTextBathingSiteWaterTemperature);
//        dateForTemp = findViewById(R.id.editTextTextBathingSiteDAteForTemp);
//
//        // Toast
//        toastName = view.findViewById(R.id.tvMessageName);
//        toastAddress = view.findViewById(R.id.tvMessageAddress);
//        toastDescription = view.findViewById(R.id.tvMessageDescription);
//        toastLongitude = view.findViewById(R.id.tvMessageLongitude);
//        toastLatitude = view.findViewById(R.id.tvMessageLatitude);
//        toastGrade = view.findViewById(R.id.tvMessageGrade);
//        toastWaterTemp = view.findViewById(R.id.tvMessageWaterTemp);
//        toastDateForTemp = view.findViewById(R.id.tvMessageDateForTemp);

    }

//    /**
//     * Clear the input fields in fragment
//     */
//    private void clearInputFields() {
//
//        name.getText().clear();
//        description.getText().clear();
//        address.getText().clear();
//        longitude.getText().clear();
//        latitude.getText().clear();
//        grade.setNumStars(0);
//        waterTemp.getText().clear();
//        dateForTemp.getText().clear();
//
//    }

    /**
     * Sets todays date in datefiled in fragment
     * */
//    private void setTodaysDate() {
//
//        // Create an instance of calendar to get todays date
//        calendar = Calendar.getInstance();
//
//        // Formatting the date
//        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        // Creates string with todays date
//        todaysDateFormatted = dateFormat.format(calendar.getTime());
//
//        // Sets the value of the field
//        dateForTemp.setText(todaysDateFormatted);
//    }

    /**
     * Check if name is empty and display an error message
     */
//    private boolean nameIsEmpty() {
//
//        // Find the views
//        findViews();
//
//        // Get field to check
//        nameCheck = name.getText().toString().trim();
//
//        // Check if string is empty
//        if (nameCheck.isEmpty()) {
//
//            // Display an error message
//            name.setError(getString(R.string.nameError));
//            return true;
//
//        }
//
//        return false;
//    }

    /**
     * Checks that if adress not submitted, both longitude and latitude must be submitted.
     * Or if either longitude or latitude not submitted, adress must be submitted. Also display
     * error message
     */
//    private boolean addressLongLatIsEmpty() {
//
//        // Get the fields to check
//        addressCheck = address.getText().toString().trim();
//        longitudeCheck = longitude.getText().toString().trim();
//        latitudeCheck = latitude.getText().toString().trim();
//
//        if (addressCheck.isEmpty() && longitudeCheck.isEmpty() && latitudeCheck.isEmpty()) {
//
//            address.setError(getString(R.string.addressError));
//            longitude.setError(getString(R.string.longitudeError));
//            latitude.setError(getString(R.string.latitudeError));
//            return true;
//
//        }
//
//        if (addressCheck.isEmpty() && longitudeCheck.isEmpty()) {
//
//            address.setError(getString(R.string.addressError));
//            longitude.setError(getString(R.string.longitudeError));
//            return true;
//
//        }
//
//        if (addressCheck.isEmpty() && latitudeCheck.isEmpty()) {
//
//            address.setError(getString(R.string.addressError));
//            latitude.setError(getString(R.string.latitudeError));
//            return true;
//        }
//
//        if (longitudeCheck.isEmpty() && latitudeCheck.isEmpty()) {
//
//            longitude.setError(getString(R.string.longitudeError));
//            latitude.setError(getString(R.string.latitudeError));
//            return true;
//        }
//
//        return false;
//
//    }

    /**
     * Displays custm toast with 8 lines of information
     */
//    private void showToast() {
//
//        // Creates the toast
//        toast = new Toast(MainActivity.this);
//
//        // Set message to be displayed
//        toastName.setText(getString(R.string.toastName)+" "+name.getText().toString());
//        toastDescription.setText(getString(R.string.toastDescription)+" "+description.getText().toString());
//        toastAddress.setText(getString(R.string.toastAddress)+" "+address.getText().toString());
//        toastLongitude.setText(getString(R.string.toastLongitude)+" "+longitude.getText().toString());
//        toastLatitude.setText(getString(R.string.toastLatitude)+" "+latitude.getText().toString());
//        toastGrade.setText(getString(R.string.toastGrade)+ " "+grade.getRating());
//        toastWaterTemp.setText(getString(R.string.toastWaterTemp)+" "+waterTemp.getText().toString());
//        toastDateForTemp.setText(getString(R.string.toastDateForTemp)+" "+dateForTemp.getText().toString());
//
//        // Set and show toast
//        toast.setView(view);
//        toast.show();
//
//    }



}