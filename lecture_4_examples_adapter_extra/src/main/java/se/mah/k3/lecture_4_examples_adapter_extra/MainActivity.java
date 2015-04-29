package se.mah.k3.lecture_4_examples_adapter_extra;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import se.mah.k3.lecture_4_examples_adapter_extra.FragmentDialog;
import se.mah.k3.lecture_4_examples_adapter_extra.FragmentList;
import se.mah.k3.lecture_4_examples_adapter_extra.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Put batman where he belongs
        ActionBar actionBar = getActionBar();
        actionBar.setLogo(R.mipmap.batman);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_layout, new FragmentList());
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_spinner) {
            FragmentManager fm = getFragmentManager();
            FragmentDialog fd = new FragmentDialog();
            Bundle b = new Bundle();
            fd.setArguments(b);
            fd.addToBackStack(null);
            fd.show(fm, "Dialog");


            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}