package com.edu4sure.myerp;

import android.widget.ImageButton;

public class CreateRetailer {
    private int image,ib;
    private String name;


    public CreateRetailer(int image, String name) {
        this.image = image;
        this.name=name;
    }//constructor ends



    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}//Create ends
