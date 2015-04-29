package se.mah.k3.lecture_4_examples_adapter_extra;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;



public class MyListAdapter extends ArrayAdapter<Planeta> {
    ArrayList<Planeta> pList;
    Context c;

    public MyListAdapter(Context context, ArrayList<Planeta> pList) {
        super(context, 0, pList);
        this.pList = pList;
        this.c = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Hide the body at position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item,null);

        //Extra space here to fit the theme of the assignment:



        Planeta p = pList.get(position);


        TextView s = (TextView) convertView.findViewById(R.id.hillbilly);
        s.setText(p.getTitle());



        ImageView l = (ImageView) convertView.findViewById(R.id.hahahah);
        l.setImageDrawable(p.getImage());



        return convertView;
    }

    public void setAdapter(MyListAdapter myAdapter) {
    }
}