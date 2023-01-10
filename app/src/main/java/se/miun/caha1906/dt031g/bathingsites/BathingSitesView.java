package se.miun.caha1906.dt031g.bathingsites;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
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

        // Inflate
        inflate(getContext(), R.layout.view_bathingsitesview, this);

        // Clicklistener for counting
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                bathingSites ++;
//            }
//        });

        // Set the OnClickListener to call incrementCounter method
//        if (this.onCounterChangeListener != null) {
//            onCounterChangeListener.onCounterChanged(bathingSites);
//        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCounter();
            }
        });

        // Retrieve custom attributes - No need?
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
     * Sets the message for the view
     * */
    private void setMessage(@NonNull String newMessage) {

        if (TextUtils.isEmpty(newMessage)) {

            return;
        }

        TextView message = findViewById(R.id.textViewBathingSitesView);
        message.setText(newMessage);

    }

    /**
     * Gets the bathingsites count from the view
     */
    public String getBathingSitesCount() {

        //TextView bathingSitesCount = findViewById(R.id.);
        //return bathingSitesCount.getText().toString();
        return "..";
    }

    /**
     * Counter for bathingsites
     */
    public void setCounter(int counter) {

        bathingSites = counter;

    }

    public int getCounter() {

        return bathingSites;

    }

    ////

    public interface OnCounterChangeListener {
        void onCounterChanged(int counter);
    }

    private OnCounterChangeListener onCounterChangeListener;

    public void setOnCounterChangeListener(OnCounterChangeListener listener) {
        this.onCounterChangeListener = listener;
    }

    private void incrementCounter() {
        bathingSites++;
        if (onCounterChangeListener != null) {
            onCounterChangeListener.onCounterChanged(bathingSites);
        }

    }

}
