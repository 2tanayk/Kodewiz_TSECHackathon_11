package com.edu4sure.myerp;

public class Create {
    private int image;
    private String name;

    public Create(int image, String name) {
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
