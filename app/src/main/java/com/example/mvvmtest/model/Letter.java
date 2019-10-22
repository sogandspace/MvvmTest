package com.example.mvvmtest.model;

public class Letter {
    private String mTitle, mDes;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDes() {
        return mDes;
    }

    public void setDes(String des) {
        mDes = des;
    }

    public Letter(String title, String des) {
        mTitle=title;
        mDes=des;
    }
}
