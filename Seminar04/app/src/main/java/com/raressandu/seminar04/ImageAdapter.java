package com.raressandu.seminar04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<RobotImage> images;
    private Context ctx;
    private Integer templateId;

    public List<RobotImage> getImages() {
        return images;
    }

    public void setImages(List<RobotImage> images) {
        this.images = images;
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

    public ImageAdapter(List<RobotImage> images, Context ctx, Integer templateId) {
        this.images = images;
        this.ctx = ctx;
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View v = layoutInflater.inflate(templateId, viewGroup, false);
        ImageView imageView = v.findViewById(R.id.imgTemplateImageView);
        TextView textView = v.findViewById(R.id.imgTemplateDesc);
        RobotImage robotImage = images.get(i);
        imageView.setImageBitmap(robotImage.getImage());
        textView.setText(robotImage.getDesc());
        return v;
    }
}
