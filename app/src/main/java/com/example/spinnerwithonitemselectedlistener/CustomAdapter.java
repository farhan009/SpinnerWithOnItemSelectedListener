package com.example.spinnerwithonitemselectedlistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] countryNames;
    private String[] countryPopulation;
    int[] flags;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, int[] flags, String[] countryNames, String[] countryPopulation){
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        this.countryPopulation = countryPopulation;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView_sampleView_id);
        TextView textView = convertView.findViewById(R.id.textView_sampleView_id);
        TextView polution = convertView.findViewById(R.id.polution_sampleView_id);

        imageView.setImageResource(flags[position]);
        textView.setText(countryNames[position]);
        polution.setText(countryPopulation[position]);

        return convertView;
    }
}
