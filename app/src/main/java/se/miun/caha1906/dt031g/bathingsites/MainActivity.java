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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    BathingSitesView bathingSitesView;
    //BathingSitesFragment bathingSitesFragment; //TODO: commented out for new! below

    private static final String TAG_FRAGMENT_BATHING_SITES = "fragment_bathing_sites"; //TODO:new!
    private BathingSitesFragment bathingSitesFragment; //TODO: new!

    int counter = 0;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_bathing_sites);
        setContentView((R.layout.activity_main));

        // Get the views
        findViews();

        bathingSitesFragment = (BathingSitesFragment) //TODO:new!
        getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_BATHING_SITES); //TODO:new!
            if (bathingSitesFragment == null) { //TODO:new!
                bathingSitesFragment = new BathingSitesFragment(); //TODO:new!
                getSupportFragmentManager().beginTransaction() //TODO:new!
                        .add(R.id.fragment_container, //TODO:new!
                                bathingSitesFragment, //TODO:new!
                                TAG_FRAGMENT_BATHING_SITES) //TODO:new!
                        .commit(); //TODO:new!
            }

            FloatingActionButton fab = findViewById(R.id.floatingActionButton); //TODO:new!
            fab.setOnClickListener(new View.OnClickListener() { //TODO:new!
                @Override //TODO:new!
                public void onClick(View view) { //TODO:new!
                    //startActivity(new Intent(MainActivity.this, AddBathingSiteActivity.class)); //TODO:new!
                    Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG);
//                        .setAction("Action", null).show();
                } //TODO:new!
            }); //TODO:new!

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
        Log.d("onCreate", "Button: " + fab);



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

        fab = findViewById(R.id.floatingActionButton);
        //bathingSitesFragment = findViewById(R.id.bathingSitesFragment);
    }

}