package com.raressandu.seminar04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class RobotAdapter extends BaseAdapter {

    private List<Robot> robots = null;
    private Context ctx;
    private int resursaLayout;

    public RobotAdapter(List<Robot> robots, Context ctx, int resursaLayout) {
        this.robots = robots;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return robots.size();
    }

    @Override
    public Object getItem(int i) {
        return robots.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        // viewGroup reprezinta listView-ul


        // Fiecare resursa are un identificator in R si findViewById primeste tot un integer, id-ul asociat cu resursa
        // Inflator face covnersia din xml in obiect java, care mai departe e afisat

        // v reprezinta un item pe care vrem sa l cream

        View v = inflater.inflate(resursaLayout, viewGroup, false);
        TextView name = v.findViewById(R.id.oneRobotName);
        TextView isSmart = v.findViewById(R.id.oneRobotSmart);
        TextView lastTimeActive = v.findViewById(R.id.oneRobotLastTimeActive);
        TextView softBytes = v.findViewById(R.id.oneRobotSoftBytes);

        Robot r = (Robot)getItem(i);
        name.setText(r.getName());
        isSmart.setText(r.getSoftBytes());
        lastTimeActive.setText(r.getSmart().toString());
        softBytes.setText(r.getLastTimeActive().toString());

        return v;
    }
}
