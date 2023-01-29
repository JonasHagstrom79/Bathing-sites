package se.miun.caha1906.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class AddBathingSiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_bathing_site);
        setContentView(R.layout.fragment_add_bathing_site);

        // Get current orientation
        int orientation = getResources().getConfiguration().orientation;

        // Check orientation and set appropriate layoute
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("If sats", "If sats ");
            setContentView(R.layout.activity_add_bathing_site_land);

        } else {

            setContentView(R.layout.activity_add_bathing_site);

        }


//        // Replace the current fragment with AddBathingSiteFragment //TODO: behövs nog ej!
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.fragment_container, new AddBathingSiteFragment());
//
//        fragmentTransaction.commit();
    }
}