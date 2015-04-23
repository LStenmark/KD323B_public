package se.mah.k3.skaneAPI;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.MyAdapter;
import se.mah.k3.skaneAPI.control.Constants;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.xmlparser.Parser;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class ExpFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    View thisView;
    private ArrayList<Journey> myItems = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        Log.i("ExpFragment", "MenuSelection. " + id);
       if (id == R.id.refresh) {
            Spinner sp = (Spinner) getView().findViewById(R.id.spinner2);
            int i = sp.getSelectedItemPosition();
            String[] sa = getActivity().getResources().getStringArray(R.array.qui);
            String course = sa[i];
           Spinner s = (Spinner) getView().findViewById(R.id.spinner3);
           int in = s.getSelectedItemPosition();
           String[] sap = getActivity().getResources().getStringArray(R.array.qui);
           String course1 = sa[in];
            MyAsyncTask myAsyncTask = new MyAsyncTask();
           myAsyncTask.execute(course1);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String[] courses = getActivity().getResources().getStringArray(R.array.qui);
        String course = courses[position];
        Log.i("ExpFragment", "Course. " + course);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(course);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment.
        View v = inflater.inflate(R.layout.activity_test, container, false);
        ///Do whatever
        thisView = v;
        ExpandableListView ev = (ExpandableListView) v.findViewById(R.id.expandableListView);
        myAdapter = new MyAdapter(getActivity(),myItems);
        ev.setAdapter(myAdapter);
        //MyAsyncTask myAsyncTask = new MyAsyncTask();
        //myAsyncTask.execute("KD323B-20151-K3522");
        Spinner sp = (Spinner)v.findViewById(R.id.spinner2);
        sp.setOnItemSelectedListener(this);

        View vii = v.findViewById(R.id.btn_search);
        vii. setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View innerView) {



                Spinner spinner = (Spinner) thisView.findViewById(R.id.spinner2);
                String txtFran = spinner.getSelectedItem().toString();
                int commaIndex = txtFran.indexOf(',');
                String stationNb = txtFran.substring(commaIndex + 1).trim();


                Spinner spinner2 = (Spinner) thisView.findViewById(R.id.spinner3);
                String txtTill = spinner2.getSelectedItem().toString();
                int commaIndex2 = txtTill.indexOf(',');
                String stationNbr = txtTill.substring(commaIndex2 + 1).trim();
                    Log.i("heej", "Tjooogo");
                String searchURL = Constants.getURL(stationNb, stationNbr, 10);
                new MyAsyncTask().execute(searchURL);

            }



        });


        return v;


    }


    //@Override
    //public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      //  inflater.inflate(R.menu.menu_test, menu);
     //   super.onCreateOptionsMenu(menu,inflater);
   // }


    //And the thread
    public class MyAsyncTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            String param1 =  params[0];

            Log.i("ExpFragment", "In ghhjjkjkk" + params[0]);
            Journeys j  = Parser.getJourneys(params[0]);
            myItems.clear();
            myItems.addAll(j.getJourneys());
            for (Journey si :j.getJourneys()){
                Log.i("ExpFragment", "test " + si.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Log.i("ExpFragment", "In background2");
            myAdapter.notifyDataSetChanged();
            for (Journey si :myItems){
                Log.i("ExpFragment", "moment" + si.toString());
            }




        }

     }

}
