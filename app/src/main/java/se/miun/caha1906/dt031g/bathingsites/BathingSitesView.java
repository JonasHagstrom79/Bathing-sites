package se.miun.caha1906.dt031g.bathingsites;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BathingSitesView extends ConstraintLayout {

    /**
     * Keeps track of the number of stored bathing sites
     */
    private int bathingSites = 0;

    // Textviews to show info
    TextView countertextView, message;

    /**
     * The view
     */
    BathingSitesView bathingSitesView = this;

    /**
     * Custom constructor to use whe setting
     * */
    public BathingSitesView(@NonNull Context context) {

        super(context);
        init(null);

    }

    /**
     * Constructor used when setting bathing sites counter
     */
    public BathingSitesView(@NonNull Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        init(null);
        // Method for setting bathing sites here
    }

    /**
     * Constructor used when creating instances of an xml file
     */
    public BathingSitesView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(null);

    }

    // MAy not be needed
    public BathingSitesView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);

    }

    /**
     * Takes care of all initialization the component needs
     */
    private void init(AttributeSet attrs) {

        // Inflate the view
        inflate(getContext(), R.layout.view_bathingsitesview, this);

        // Get the views
        findViews();

        // Set clicklistener to be able to add bathingsites
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                incrementCounter();

            }
        });

        // Retrieve custom attributes - //TODO: No need?
        TypedArray customAttributes = getContext().getTheme().obtainStyledAttributes(
                attrs, // The base set of attribute values. May be null.
                R.styleable.BathingSitesView, // Our custom attributes to be retrieved (in res/values/attrs.xml).
                0,0); // 0 = do to not look for default values

        String message;

        // Get the values from the custom attributes
        try {
            message = customAttributes.getString(
                    R.styleable.BathingSitesView_message);

        } finally {
            customAttributes.recycle();
        }

        // Update the view to show string from attribute
        setMessage(message);

        // Call setSaveEnabled(true) to indicate that this view intends to save its state
        setSaveEnabled(true);

    }

//    @Override
//    public void setOnClickListener(@Nullable OnClickListener l) {
//
//        super.setOnClickListener(l);
//
//    }

    /**
     * Sets the message for the view
     * */
     public void setMessage(@NonNull String newMessage) {

         // Check if string i empty
         if (TextUtils.isEmpty(newMessage)) {

             return;

         }

        // Set the message
        message = findViewById(R.id.textViewBathingSitesView);
        message.setText(newMessage);

    }

    /**
     * Adds one bathingplace for each click on the picture
     */
    private void incrementCounter() {

        // Add one for each click
        bathingSites++;

        countertextView = findViewById(R.id.textViewBathingSitesView);
        
        // Set the text for the view
        countertextView.setText(String.valueOf(bathingSites + getContext().getString(R.string.BathingSitesViewCounterText)));

    }

    /**
     * Get the views
     */
    private void findViews() {

        countertextView = findViewById(R.id.textViewBathingSitesView);
        message = findViewById(R.id.textViewBathingSitesView);

    }

}
