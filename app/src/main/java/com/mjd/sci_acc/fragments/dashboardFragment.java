package com.mjd.sci_acc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.mjd.sci_acc.Dash.OSI_Dash;
import com.mjd.sci_acc.Dash.home_Dash;
import com.mjd.sci_acc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class dashboardFragment extends Fragment {
    public WebView webView;
    TextView wlcUser;
    CardView home, osiDash;

    public dashboardFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        home = view.findViewById(R.id.homeDash);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Loading.. \n Let's Discover AIU Online ✨", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), home_Dash.class));
            }

        });
        osiDash = view.findViewById(R.id.osiDash);
        osiDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Loading.. \nAll Student Required Services are Here! ⭐", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getActivity(), OSI_Dash.class));
            }

        });
//    wlcUser =view.findViewById(R.id.txtHello);
//        wlcUser.setText("");
        return view;
    }
}