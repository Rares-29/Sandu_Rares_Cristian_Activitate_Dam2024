package com.raressandu.testpractice10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter extends BaseAdapter {

    List<Dog> dogList;
    Context context;
    int templateId;

    public DogAdapter(List<Dog> dogList, Context context, int templateId) {
        this.dogList = dogList;
        this.context = context;
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        return dogList.size();
    }

    @Override
    public Object getItem(int i) {
        return dogList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(templateId, viewGroup, false);
        TextView tv = v.findViewById(R.id.templateName);
        ImageView iv = v.findViewById(R.id.templateImg);
        TextView tv2 = v.findViewById(R.id.templateLink);
        Dog dog = dogList.get(i);
        tv.setText(dog.getName());
        tv2.setText(dog.getLink());
        iv.setImageBitmap(dog.getBitmap());
        return v;
    }
}
