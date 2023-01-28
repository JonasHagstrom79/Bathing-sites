package se.miun.caha1906.dt031g.bathingsites;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddBathingSiteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddBathingSiteFragment extends androidx.fragment.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddBathingSiteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddBathingSiteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddBathingSiteFragment newInstance(String param1, String param2) {
        AddBathingSiteFragment fragment = new AddBathingSiteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_bathing_site, container, false); //TODO:commented out

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_bathing_site, container, false);

        // Get the field for date
        EditText dateInput = view.findViewById(R.id.editTextTextBathingSiteDAteForTemp);

        // Create a new object for todays date
        Date today = Calendar.getInstance().getTime();

        // Format the date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String todayString = sdf.format(today);

        // Set todays date
        dateInput.setText(todayString);

        return view;
    }

}