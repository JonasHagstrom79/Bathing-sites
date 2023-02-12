package se.miun.caha1906.dt031g.bathingsites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BathingSitesView extends ConstraintLayout {

    // Textview
    TextView message;

    // Listener for when the count changes
    private OnCounterChangeListener listener;

    // Instance of the BathingSitesView class
    BathingSitesView b = this;

    // Interface for the OnCounterChangeListener, from lab assignment
    public interface OnCounterChangeListener {

        // Callback method to be invoked when the counter changes
        void onClick(BathingSitesView b);

    }

    /**
     * Custom constructor
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

    }

    /**
     * Constructor used when creating instances of an xml file
     */
    public BathingSitesView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    /**
     * Takes care of all initialization the component needs
     */
    private void init(AttributeSet attrs) {

        // Inflate the view
        inflate(getContext(), R.layout.view_bathingsitesview, this);

        // Get the views
        findViews();

        // Click event for the fragment
        animeteClick();

        // Retrieve custom attributes, from lab assignment
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

    /**
     * Sets the listener for when the count changes
     */
    public void setOnCounterChangeListener(OnCounterChangeListener listener) {

        this.listener = listener;

    }

    /**
     * Sets up the touch event for the view
     */
    @SuppressLint("ClickableViewAccessibility")
    private void animeteClick() { //From my lab assignment
        setOnTouchListener((view, motionEvent) -> {

            switch (motionEvent.getAction()) {
                // When pushed
                case MotionEvent.ACTION_DOWN:

                    // Initiate custom listener from
                    setOnCounterChangeListener(listener);
                    if (this.listener != null) {
                        listener.onClick(this);

                    }
                    // Increment the count in the MainActivity
                    if (getContext() instanceof  MainActivity) {

                        ((MainActivity) getContext()).incrementBathingSitesCount();

                    }

                    break;
                // When released
                case MotionEvent.ACTION_UP:
                    //
                    break;
            }

            return true;

        });
    }

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
     * Get the views
     */
    private void findViews() {

        message = findViewById(R.id.textViewBathingSitesView);

    }



}
