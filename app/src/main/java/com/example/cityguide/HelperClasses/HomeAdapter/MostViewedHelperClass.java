package com.example.cityguide.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {

    int mvImage;
    String mvTitle, mvDescription;

    public MostViewedHelperClass(int mvImage, String mvTitle, String mvDescription) {
        this.mvImage = mvImage;
        this.mvTitle = mvTitle;
        this.mvDescription = mvDescription;
    }

    public int getMvImage() {
        return mvImage;
    }

    public String getMvTitle() {
        return mvTitle;
    }

    public String getMvDescription() {
        return mvDescription;
    }
}
