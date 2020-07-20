package com.example.rebootapps.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rebootapps.R;
import com.example.rebootapps.ui.FragIntro;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragMyDay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragMyDay extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragMyDay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragIntro.
     */
    // TODO: Rename and change types and number of parameters
    public static FragMyDay newInstance(String param1, String param2) {
        FragMyDay fragment = new FragMyDay();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myday, container, false);
        // Inflate the layout for this fragment
        TextView textView = v.findViewById(R.id.text_dashboard);
        TextView btnNext = v.findViewById(R.id.btnLetsGo);
        LinearLayout btnAnxious = v.findViewById(R.id.btnAnxious);
        LinearLayout btnHappy = v.findViewById(R.id.btnHappy);
        LinearLayout btnNeutral = v.findViewById(R.id.btnNeutral);
        LinearLayout btnExited = v.findViewById(R.id.btnExited);
        LinearLayout btnSad = v.findViewById(R.id.btnSad);
        LinearLayout btnConfused = v.findViewById(R.id.btnConfused);
        LinearLayout btnStressed = v.findViewById(R.id.btnStressed);
        LinearLayout btnAngry = v.findViewById(R.id.btnAngry);
        btnNext.setEnabled(false);
        textView.setText("Good morning, Ilham!\nHow do you feel right now?");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.navigation_myday, new FragIntro(), "Intro");
                ft.commit();
                ft.addToBackStack(null);
            }
        });

        btnAnxious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(1f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });

        btnAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(1f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });

        btnExited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(1f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(1f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });
        btnNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(1f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });
        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(1f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(0.30f);
            }
        });
        btnConfused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(1f);
                btnStressed.setAlpha(0.30f);
            }
        });
        btnStressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setEnabled(true);
                btnNext.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnAnxious.setAlpha(0.30f);
                btnAngry.setAlpha(0.30f);
                btnExited.setAlpha(0.30f);
                btnHappy.setAlpha(0.30f);
                btnNeutral.setAlpha(0.30f);
                btnSad.setAlpha(0.30f);
                btnConfused.setAlpha(0.30f);
                btnStressed.setAlpha(1f);
            }
        });


        return v;
    }
}