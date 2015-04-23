package se.mah.k3.skaneAPI.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.ExpFragment;
import se.mah.k3.skaneAPI.R;
import se.mah.k3.skaneAPI.model.Journey;


public class TestActivity extends Activity {
    View thisView;
    private ArrayList<Journey> journeyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_activity_layout, new ExpFragment());
        ft.commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        //Log.i("ExpFragment", "MenuSelection. " + id);
        //if (id == R.id.refresh) {
        //  Spinner sp = (Spinner) findViewById(R.id.spinner2);
        //  int i = sp.getSelectedItemPosition();
        //  String[] sa = getResources().getStringArray(R.array.qui);
        // String course = sa[i];
        // Spinner s = (Spinner) findViewById(R.id.spinner3);
        // int in = s.getSelectedItemPosition();
        // String[] sap = getResources().getStringArray(R.array.qui);
        // String course1 = sa[in];
        //ExpFragment.MyAsyncTask myAsyncTask = new ExpFragment.MyAsyncTask();
        //myAsyncTask.execute(course1);
        //return true;
        //  } else {
           return super.onOptionsItemSelected(item);
         }


        // }



 }