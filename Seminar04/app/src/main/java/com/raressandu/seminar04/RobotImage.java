package com.raressandu.seminar04;

import android.graphics.Bitmap;

public class RobotImage {

    private Bitmap image;
    private String desc;
    private String link;

    public RobotImage(Bitmap image, String desc, String link) {
        this.image = image;
        this.desc = desc;
        this.link = link;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
