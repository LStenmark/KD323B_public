package se.mah.k3.lecture_4_examples_adapter_extra;


import android.view.View;
import android.view.ViewGroup;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;



/**
 * A simple {@link android.app.Fragment} subclass.
 */


public class FragmentDialog extends DialogFragment implements View.OnClickListener{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__dialog, container, false);
        v.setOnClickListener(this);

        return v;
    }






    @Override
    public void onClick(View v) {
        FragmentDialog.this.dismiss();

    }

    public void addToBackStack(Object o) {
    }
}

