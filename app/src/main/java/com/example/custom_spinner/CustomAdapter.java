package com.example.custom_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int images[];
    private String countries[];
    private String capital[];
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int[] images, String[] countries,String[] capital) {
        this.context = context;
        this.images = images;
        this.countries = countries;
        this.capital = capital;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position] + ", " + capital[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.custom_lv_layout, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.imageView2);
        TextView str = (TextView) view.findViewById(R.id.textView2);
        TextView str2 = (TextView) view.findViewById(R.id.textView3);
        str.setText(countries[i]);
        str2.setText(capital[i]);
        img.setImageResource(images[i]);
        return view;
    }
}
