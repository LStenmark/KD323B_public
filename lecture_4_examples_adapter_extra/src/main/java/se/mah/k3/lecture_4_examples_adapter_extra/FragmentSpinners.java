package se.mah.k3.lecture_4_examples_adapter_extra;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;



/**
 * A simple {@link android.app.Fragment} subclass.
 */

public class FragmentSpinners extends Fragment  {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_with_spinners, container, false);
        Planeta p = (Planeta) getArguments().getSerializable("planet");

        TextView tack = (TextView) v.findViewById(R.id.planetnamn);
        ImageView naw = (ImageView) v.findViewById(R.id.planetbild);
        TextView temper = (TextView) v.findViewById(R.id.planetstuff);
        TextView iloveu = (TextView) v.findViewById(R.id.scroll_lol);
        TextView rarrrraar = (TextView) v.findViewById(R.id.WhatWasThis);


        tack.setText(p.getTitle());

        temper.setText("Temperatur: " + p.getTempan());
        rarrrraar.setText("Radie: " + p.getRadie());

        iloveu.setText(p.getSummakardemumma());
        naw.setImageDrawable(p.getImage());

        return v;

    }


}
