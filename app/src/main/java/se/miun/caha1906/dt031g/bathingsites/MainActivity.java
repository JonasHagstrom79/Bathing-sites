package se.miun.caha1906.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    //BathingSitesView bathingSitesView;
    //BathingSitesFragment bathingSitesFragment; //TODO: commented out for new! below

    private static final String TAG_FRAGMENT_BATHING_SITES = "fragment_bathing_sites"; //TODO:new!
    private BathingSitesFragment bathingSitesFragment; //TODO: new!

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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //savedInstanceState.putInt(); //TODO:här!!!!
        super.onCreate(savedInstanceState);

        setContentView((R.layout.activity_main));

        // Get the views
        findViews();
        //@SuppressLint({"MissingInflatedId", "LocalSuppress"}) BathingSitesView bathingSiteView = findViewById(R.id.bathing_site_view);
        //BathingSitesView bathingSiteView = new BathingSitesView(this); //TODO: funkar med denna me hänns fel?

        // Set listener to bathingsitesView //TODO: HERE; WONT WORK(NULL!)

        // Get the textview to display counter
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView counterText = findViewById(R.id.textViewBathingSitesView);

        // Get the bathingsitesview
//        bathingSiteView = findViewById(R.id.bathing_site_view);
//        Log.d("BS","BathingsitesView" + bathingSiteView);
//        bathingSiteView.setOnCounterChangeListener(new BathingSitesView.OnCounterChangeListener() {
//            @Override
//            public void onCounterChanged(int counter) {
//                Toast.makeText(MainActivity.this, "HIhihih", Toast.LENGTH_SHORT).show();
//                Log.d("CustomView", "Counter: " + counter);
//                 counterText.setText(String.valueOf(counter));
//            }
//        });

        ///MENU TESTAR///



//        bathingSiteView.setOnCounterChangeListener(new BathingSitesView.OnCounterChangeListener() {
//            @Override
//            public void onCounterChanged(int counter) {
//                Log.d("Click", "Click");
//                bathingSiteView.setCounter(counter);
//            }
//        });

//        bathingSiteView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Click", "Click");
//            }
//        });

//        bathingSiteView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Click", "Click");
//                bathingSiteView.setCounter(bathingSiteView.getCounter() + 1);
//            }
//        });

        // Creates transaction for fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Creates new fragment
        BathingSitesFragment bathingSitesFragment = new BathingSitesFragment();

        // Adds to transaction container
        transaction.replace(R.id.fragment_container, bathingSitesFragment, TAG_FRAGMENT_BATHING_SITES);
        transaction.addToBackStack(null);
        transaction.commit();

        //For testing //TODO:remove!
        // Replace the current fragment with AddBathingSiteFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, new AddBathingSiteFragment());

        fragmentTransaction.commit();
        // For testing //TODO:remove!

        // Sets click listener on the button
        fab.setOnClickListener(view -> {

            // Creates an intent to start AddBathingSitesActivity
            Intent addBathingSiteIntent = new Intent(MainActivity.this,
                    AddBathingSiteActivity.class);

            startActivity(addBathingSiteIntent);
            //showToast(); //TODO:For testing!

        });

//        FloatingActionButton fab = findViewById(R.id.floatingActionButton); //TODO:new!
//
//        Log.d("kjgkjjgjkfkh", "fab"+fab );
//
//        fab.setOnClickListener(view -> { //TODO:new!
//            //startActivity(new Intent(MainActivity.this, AddBathingSiteActivity.class)); //TODO:new!
//            Log.d("Click", "Click");
//            Toast.makeText(this, "Should start a new bathingsitesactivity", Toast.LENGTH_SHORT).show();
//        }); //TODO:new!

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Click", "Click");
//            }
//        });

        // Find the fragment container view
//        FrameLayout fragmentContainer = findViewById(R.id.fragment_container);
//
//        // Add the fragment to the container
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_container, new BathingSitesFragment())
//                .commit();

//        // Add the BathingSitesFragment to the activity
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.fragment_container, new BathingSitesFragment());
//        ft.commit();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.bathingSitesFragment, new BathingSitesFragment());
//        ft.commit();

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.bathing_site_view, new BathingSitesFragment());
//        fragmentTransaction.commit();

        Log.d("MainActivity", "Layout file: " + R.layout.activity_main);
//        Log.d("onCreate", "Button: " + fab);



        // Sets clicklistener for floatibg button //TODO: 2023-01-06 commented out for testing new! above
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                // TODO: task 5
////                Intent intent = new Intent(MainActivity.this,
////                        NewBathingSiteActivity.class);
////                startActivity(intent);
//            }
//        });
    }

    // Gets the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    // Handle Clear and save
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Clear the input
        if (item.getItemId() == R.id.action_clear) {

            // Get the views
            findViews();

            // Clear the inputfields and set todays date
            clearInputFields();

            setTodaysDate();

            return true;
        }

        // Saves the input
        if (item.getItemId() == R.id.action_save) {
            showToast();
            if (nameIsEmpty()) {
                // Displays error messgage
                //name.setError(getString(R.string.nameError));

            }
            if (addressLongLatIsEmpty()) {
                // Displays error message
                //TODO: locic here or in method?
            }else {
                findViews();
//                showToast();

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Get the views
     */
    private void findViews() {

        //fab = findViewById(R.id.floatingActionButton);//TODO:2023-01-10
        //bathingSiteView = findViewById(R.id.bathing_site_view);

        //bathingSitesFragment = findViewById(R.id.bathingSitesFragment);

        fab = findViewById(R.id.floatingActionButton2);

        // Inflates the view for the toast message //TODO:really here?
        view = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.toast_layout, null);

        // Edit text
        name = findViewById(R.id.editTextTextBathingSiteName);
        description = findViewById(R.id.editTextTextBathigSiteDescription);
        address = findViewById(R.id.editTextTextBathingSiteAddress);
        longitude = findViewById(R.id.editTextTextBathingSiteLongitude);
        latitude = findViewById(R.id.editTextTextBathingSiteLatitude);
        grade = findViewById(R.id.ratingBar);
        waterTemp = findViewById(R.id.editTextTextBathingSiteWaterTemperature);
        dateForTemp = findViewById(R.id.editTextTextBathingSiteDAteForTemp);

        // Toast
        toastName = view.findViewById(R.id.tvMessageName);
        toastAddress = view.findViewById(R.id.tvMessageAddress);
        toastDescription = view.findViewById(R.id.tvMessageDescription);
        toastLongitude = view.findViewById(R.id.tvMessageLongitude);
        toastLatitude = view.findViewById(R.id.tvMessageLatitude);
        toastGrade = view.findViewById(R.id.tvMessageGrade);
        toastWaterTemp = view.findViewById(R.id.tvMessageWaterTemp);
        toastDateForTemp = view.findViewById(R.id.tvMessageDateForTemp);

    }

    /**
     * Clear the input fields in fragment
     */
    private void clearInputFields() {

        name.getText().clear();
        description.getText().clear();
        address.getText().clear();
        longitude.getText().clear();
        latitude.getText().clear();
        grade.setNumStars(0);
        waterTemp.getText().clear();
        dateForTemp.getText().clear();

    }

    /**
     * Sets todays date in datefiled in fragment
     * */
    private void setTodaysDate() {

        // Create an instance of calendar to get todays date
        calendar = Calendar.getInstance();

        // Formatting the date
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Creates string with todays date
        todaysDateFormatted = dateFormat.format(calendar.getTime());

        // Sets the value of the field
        dateForTemp.setText(todaysDateFormatted);
    }

    /**
     * Check if name is empty
     */
    private boolean nameIsEmpty() {

        // Fid the views
        findViews();

        // Get the string
        nameCheck = name.getText().toString().trim();

        // Check if string is empty
        if (nameCheck.isEmpty()) {

            name.setError(getString(R.string.nameError));
            return true;

        }

        return false;
    }

    /**
     * Checks that if adress not submitted, both longitude and latitude must be submitted.
     * Or if either longitude or latitude not submitted, adress must be submitted.
     */
    private boolean addressLongLatIsEmpty() {

        addressCheck = address.getText().toString().trim();
        longitudeCheck = longitude.getText().toString().trim();
        latitudeCheck = latitude.getText().toString().trim();

        if (addressCheck.isEmpty() && (longitudeCheck.isEmpty() || latitudeCheck.isEmpty())) {
            // Show error message because either longitude or latitude must be entered if address is not entered
            address.setError(getString(R.string.addressError));
            return true;
        } else if (longitudeCheck.isEmpty() || latitudeCheck.isEmpty()) {
            // Show error message because either address, longitude or latitude must be entered
            if (longitudeCheck.isEmpty()) {
                longitude.setError(getString(R.string.longitudeError));
                return true;
            }
            if (latitudeCheck.isEmpty()) {
                latitude.setError(getString(R.string.latitudeError));
                return true;
            } else {
                return false;
            }

        }
        return true;
//            return true;
//        } else {
//            // Continue with process, all required fields are entered
//
//            return false;
//        }

    }

    /**
     * Displays custm toast with 8 lines of information
     */
    private void showToast() {

        // Creates the toast
        toast = new Toast(MainActivity.this);

        // Inflates the view
//        View view = LayoutInflater.from(MainActivity.this)
//                .inflate(R.layout.toast_layout, null);
//
//        toastName = view.findViewById(R.id.tvMessageName);
//        toastAddress = view.findViewById(R.id.tvMessageAddress);
//        toastDescription = view.findViewById(R.id.tvMessageDescription);
//        toastLongitude = view.findViewById(R.id.tvMessageLongitude);
//        toastLatitude = view.findViewById(R.id.tvMessageLatitude);
//        toastGrade = view.findViewById(R.id.tvMessageGrade);
//        toastWaterTemp = view.findViewById(R.id.tvMessageWaterTemp);
//        toastDateForTemp = view.findViewById(R.id.tvMessageDateForTemp);

        // Set message to be displayed
        toastName.setText(getString(R.string.toastName)+" "+"Önsjön");
        toastDescription.setText(getString(R.string.toastDescription)+" "+ "Placeholder");
        toastAddress.setText(getString(R.string.toastAddress)+" "+"Önsjön, Östersund");
        toastLongitude.setText(getString(R.string.toastLongitude)+" "+"14,688506");
        toastLatitude.setText(getString(R.string.toastLatitude)+" "+"63,261078");
        toastGrade.setText(getString(R.string.toastGrade)+ " "+"4.0");
        toastWaterTemp.setText(getString(R.string.toastWaterTemp)+" "+"10.4");
        toastDateForTemp.setText(getString(R.string.toastDateForTemp)+" "+"2020-08-13");

        // Set and show toast
        toast.setView(view);
        toast.show();
    }



}