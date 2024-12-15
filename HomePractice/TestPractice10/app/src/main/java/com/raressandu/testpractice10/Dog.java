package com.raressandu.testpractice10;

import android.graphics.Bitmap;

public class Dog {

    private String name;
    private Bitmap bitmap;
    private String link;

    public Dog(String name, Bitmap bitmap, String link) {
        this.name = name;
        this.bitmap = bitmap;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", bitmap=" + bitmap +
                ", link='" + link + '\'' +
                '}';
    }
}
