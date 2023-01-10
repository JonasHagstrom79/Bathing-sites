package se.miun.caha1906.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //FloatingActionButton fab; //TODO:2023-01-10
    BathingSitesView bathingSiteView;

    //BathingSitesView bathingSitesView;
    //BathingSitesFragment bathingSitesFragment; //TODO: commented out for new! below

    private static final String TAG_FRAGMENT_BATHING_SITES = "fragment_bathing_sites"; //TODO:new!
    private BathingSitesFragment bathingSitesFragment; //TODO: new!



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView((R.layout.activity_main));

        // Get the views
        findViews();
        //@SuppressLint({"MissingInflatedId", "LocalSuppress"}) BathingSitesView bathingSiteView = findViewById(R.id.bathing_site_view);
        //BathingSitesView bathingSiteView = new BathingSitesView(this); //TODO: funkar med denna me hänns fel?

        // Set listener to bathingsitesView //TODO: HERE; WONT WORK(NULL!)

        bathingSiteView = findViewById(R.id.bathing_site_view);
        Log.d("BS","BathingsitesView" + bathingSiteView);
//        bathingSiteView.setOnCounterChangeListener(new BathingSitesView.OnCounterChangeListener() {
//            @Override
//            public void onCounterChanged(int counter) {
//                Log.d("Click", "Click");
//                bathingSiteView.setCounter(counter);
//            }
//        });

        bathingSiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click", "Click");
            }
        });
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

        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton2);
        fab2.setOnClickListener(view -> {
            Toast.makeText(this, "Should start a new bathingsitesactivity", Toast.LENGTH_SHORT).show();
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

    /**
     * Get the views
     */
    private void findViews() {

        //fab = findViewById(R.id.floatingActionButton);//TODO:2023-01-10
        //bathingSiteView = findViewById(R.id.bathing_site_view);

        //bathingSitesFragment = findViewById(R.id.bathingSitesFragment);
    }

}