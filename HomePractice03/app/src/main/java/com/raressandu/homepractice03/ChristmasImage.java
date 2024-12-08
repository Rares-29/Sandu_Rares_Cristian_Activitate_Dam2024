package com.raressandu.homepractice03;

import android.graphics.Bitmap;

public class ChristmasImage {

    private Bitmap image;
    private String title;
    private String link;


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ChristmasImage(Bitmap image, String title, String link) {
        this.image = image;
        this.title = title;
        this.link = link;
    }
}
