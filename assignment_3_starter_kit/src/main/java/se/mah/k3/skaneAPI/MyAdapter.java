package se.mah.k3.skaneAPI;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.model.Journey;

/**
 * Created by K3LARA on 13/04/2015.
 */
public class MyAdapter extends BaseExpandableListAdapter {
        private ArrayList<Journey> allJourneys;
        private Context c;

    public MyAdapter(Context c, ArrayList<Journey> allJourneys){
        this.c=c;
        this.allJourneys = allJourneys!= null? allJourneys: null;
    }

    @Override
    public int getGroupCount() {
       if(allJourneys == null) return 0;
        return allJourneys.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.grouplayout,null);

        TextView timeStart = (TextView) convertView.findViewById(R.id.timeStart);
        String dep = allJourneys.get(groupPosition).getTimeToDeparture() + " min";
        Log.i("Wooow", dep.toString());
        timeStart.setText(dep);

        TextView timeArrival =(TextView) convertView.findViewById(R.id.timeArrival);
        String arr = allJourneys.get(groupPosition).getLineTypeName();
        Log.i("hejdå", arr.toString());
        timeArrival.setText(arr);

        ImageView triangle = (ImageView) convertView.findViewById(R.id.image);
        if(allJourneys.get(groupPosition).getDepTimeDeviation() != "") {
            triangle.setImageResource(R.drawable.exclamation);
        }else{
            triangle.setImageResource(R.drawable.error_icon);
        }

        TextView Byten = (TextView) convertView.findViewById(R.id.Byten);
        String Bytena = allJourneys.get(groupPosition).getNoOfChanges();
        Byten.setText(Bytena);

        TextView Duration = (TextView) convertView.findViewById(R.id.Duration);
        String durr = allJourneys.get(groupPosition).getTravelMinutes()+ " min";
        Duration.setText(durr);


        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.group_child,null);

        TextView tvRoom = (TextView) convertView.findViewById(R.id.zone);
        String room = allJourneys.get(groupPosition).getNoOfZones();
        tvRoom.setText(room);

        TextView tvEnd = (TextView) convertView.findViewById(R.id.textView5);
        String dato = allJourneys.get(groupPosition).getLineOnFirstJourney();
        tvEnd.setText(dato);


        TextView honey = (TextView) convertView.findViewById(R.id.textView4);
        String jippi = ""+ allJourneys.get(groupPosition).getTravelMinutes()+ " min";
        honey.setText(jippi);



        return convertView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
