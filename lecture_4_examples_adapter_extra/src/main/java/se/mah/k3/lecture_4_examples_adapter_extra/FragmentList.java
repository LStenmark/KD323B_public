package se.mah.k3.lecture_4_examples_adapter_extra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;


/**
 * A simple {@link android.app.Fragment} subclass.
 */


public class FragmentList extends Fragment {

    public static ArrayList<Planeta> plums = new ArrayList<Planeta>();

    //This method comes first so step aside
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        plums.clear();

        String please = getResources().getString(R.string.mer_rad);
        String remove = getResources().getString(R.string.mercury_tempydempy);
        Drawable your = getResources().getDrawable(R.drawable.me);
        String tongue = getResources().getString(R.string.mer_sum);
        plums.add(new Planeta("Mercury",please,remove,your,tongue));

        please = getResources().getString(R.string.ven_rad);
        remove = getResources().getString(R.string.venus_tempydempy);
        your = getResources().getDrawable(R.drawable.ve);
        tongue = getResources().getString(R.string.ven_sum);

        plums.add(new Planeta("Venus",please,remove,your,tongue));

        please = getResources().getString(R.string.ear_rad);
        your = getResources().getDrawable(R.drawable.ea);
        tongue = getResources().getString(R.string.ear_sum);
        remove = getResources().getString(R.string.earth_tempydempy);
        plums.add(new Planeta("Earth",please,remove,your,tongue));

        remove = getResources().getString(R.string.mars_tempydempy);
        your = getResources().getDrawable(R.drawable.ma);
        tongue = getResources().getString(R.string.mar_sum);
        please = getResources().getString(R.string.mar_rad);

        plums.add(new Planeta("Mars",please,remove,your,tongue));

        remove = getResources().getString(R.string.jupiter_tempydempy);
        please = getResources().getString(R.string.jup_rad);
        your = getResources().getDrawable(R.drawable.ju);
        tongue = getResources().getString(R.string.jup_sum);
        plums.add(new Planeta("Jupiter",please,remove,your,tongue));

        remove = getResources().getString(R.string.saturn_tempydempy);
        your = getResources().getDrawable(R.drawable.sa);
        tongue = getResources().getString(R.string.sat_sum);
        please = getResources().getString(R.string.sat_rad);

        plums.add(new Planeta("Saturn",please,remove,your,tongue));

        your = getResources().getDrawable(R.drawable.ur);
        tongue = getResources().getString(R.string.ura_sum);
        remove = getResources().getString(R.string.uranus_tempydempy);
        please = getResources().getString(R.string.ura_rad);

        plums.add(new Planeta("Uranus",please,remove,your,tongue));

        remove = getResources().getString(R.string.neptune_tempydempy);
        your = getResources().getDrawable(R.drawable.ne);
        tongue = getResources().getString(R.string.nep_sum);
        please = getResources().getString(R.string.nep_rad);
        plums.add(new Planeta("Neptune",please,remove,your,tongue));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_with_list, container, false);
        Log.i("FragmentWithList","NumberOfBooks: " + plums.size());
        MyListAdapter la = new MyListAdapter(getActivity(),plums);
        GridView host = (GridView) v.findViewById(R.id.TurnDownForGrid);
        host.setAdapter(la);
        host.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked eeeree: " + position);
              FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentSpinners fragmentSpinners = new FragmentSpinners();
                Bundle b = new Bundle();
                b.putSerializable("planet", plums.get(position));
                fragmentSpinners.setArguments(b);
                ft.replace(R.id.gridy, fragmentSpinners);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }

}
