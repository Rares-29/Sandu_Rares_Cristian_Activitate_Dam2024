package com.raressandu.prepareforexam03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {

    private ArrayList<Task> tasks;
    private Context ctx;
    private Integer templateId;

    public TaskAdapter(ArrayList<Task> tasks, Context ctx, Integer templateId) {
        this.tasks = tasks;
        this.ctx = ctx;
        this.templateId = templateId;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }



    @Override
    public String toString() {
        return "TaskAdapter{" +
                "tasks=" + tasks +
                ", ctx=" + ctx +
                ", templateId=" + templateId +
                '}';
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View v = layoutInflater.inflate(templateId, viewGroup, false);
        TextView viewAssignee = v.findViewById(R.id.templateAssignee);
        TextView viewDeadline = v.findViewById(R.id.templateDeadline);
        TextView viewDesc = v.findViewById(R.id.templateDesc);
        TextView viewDifficulty = v.findViewById(R.id.templateDifficulty);
        TextView viewTitle = v.findViewById(R.id.templateTitle);

        Task t = tasks.get(i);
        viewAssignee.setText(t.getAssignee());
        viewDeadline.setText(t.getDeadline().toString());
        viewTitle.setText(t.getTitle());
        viewDifficulty.setText(t.getDifficulty().toString());
        viewDesc.setText(t.getDescription());
        return v;
    }
}
