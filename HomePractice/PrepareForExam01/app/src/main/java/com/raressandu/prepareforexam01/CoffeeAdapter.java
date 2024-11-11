package com.raressandu.prepareforexam01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CoffeeAdapter extends BaseAdapter {

    ArrayList<Coffee> coffees;
    Context ctx;
    Integer templateId;

    public CoffeeAdapter(ArrayList<Coffee> coffees, Context ctx, Integer templateId) {
        this.coffees = coffees;
        this.ctx = ctx;
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        return coffees.size();
    }

    @Override
    public Object getItem(int i) {
        return coffees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(templateId, viewGroup, false);
        TextView description = v.findViewById(R.id.templateDesc);
        TextView price = v.findViewById(R.id.templatePrice);
        TextView coffeine = v.findViewById(R.id.templateCoffeine);

        Coffee c = coffees.get(i);
        description.setText(c.denumire);
        price.setText(c.price.toString());
        String caf = c.cafeina ? "Contine cafeina" : "Nu contine cafeina";
        coffeine.setText(caf);
        return v;
    }
}
