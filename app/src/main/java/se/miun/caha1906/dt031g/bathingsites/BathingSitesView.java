package se.miun.caha1906.dt031g.bathingsites;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BathingSitesView extends ConstraintLayout {

    /**
     * Keeps track of the number of stored bathing sites
     */
    private int bathingSites;

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

        // Animate clicks maybe?

        // Retrieve custom attributes - No need?
//        TypedArray customAttributes = getContext().getTheme().obtainStyledAttributes(
//                attrs,
//                R.styleable
//        )
    }

    /**
     * Gets the bathingsites count from the view
     */
    public String getBathingSitesCount() {

        //TextView bathingSitesCount = findViewById(R.id.);
        //return bathingSitesCount.getText().toString();
        return "..";
    }
}
