package se.mah.k3.lecture_4_examples_adapter_extra;

import android.graphics.drawable.Drawable;
import java.io.Serializable;


public class Planeta implements Serializable {
    String title;
    String radie;
    String tempan;
    Drawable image;
    String summakardemumma;

    public Planeta(String title, String radie, String tempan, Drawable image, String summakardemumma) {
        this.title = title;
        this.tempan = tempan;
        this.image = image;
        this.radie= radie;
        this.summakardemumma = summakardemumma;

    }

    public String getTempan() {
        return tempan;
    }

    public void setTempan(String tempan) {
        this.tempan = tempan;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRadie() {
        return radie;
    }

    public void setRadie(String radius) {
        this.radie = radius;
    }



    @Override
    public String toString() {
        return title;
    }

    public String getSummakardemumma()
    {
        return summakardemumma;}

    public void setSummakardemumma(String summakardemumma)
    {
        this.summakardemumma=summakardemumma;
    }

}