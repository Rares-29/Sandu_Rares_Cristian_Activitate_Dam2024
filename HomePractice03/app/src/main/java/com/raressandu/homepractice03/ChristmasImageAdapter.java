package com.raressandu.homepractice03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChristmasImageAdapter extends BaseAdapter {

    private Integer templateId;
    private List<ChristmasImage> images;
    private Context ctx;

    public ChristmasImageAdapter(Integer templateId, List<ChristmasImage> images, Context ctx) {
        this.templateId = templateId;
        this.images = images;
        this.ctx = ctx;
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View v = layoutInflater.inflate(templateId, viewGroup, false);
        TextView textView = v.findViewById(R.id.templateText);
        ImageView imageView = v.findViewById(R.id.templateImg);
        ChristmasImage christmasImage = images.get(i);
        textView.setText(christmasImage.getLink());
        imageView.setImageBitmap(christmasImage.getImage());

        return v;
    }
}
