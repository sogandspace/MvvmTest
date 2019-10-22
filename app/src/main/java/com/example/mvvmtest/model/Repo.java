package com.example.mvvmtest.model;

import android.os.Handler;

import java.util.List;

import javax.security.auth.callback.Callback;

public class Repo {

    private Letter mLetter;
    private static Repo mInstance;

    public Repo() {
            Letter letter = new Letter("Sky", "You’re beautifully entangled with everything." +
                    " With everyone you love. When you feel it, life is better than good. But, " +
                    "of course, it doesn’t always feel like it. Life can be HARD, confusing, chaotic. " +
                    "Here’s a spiritual writing exercise to get you out of your own head and into your heart.\n" +
                    "\n" +
                    "Jotting down your feelings, positive and negative, " +
                    "reduces stress and its impact on your physical health. While it might seem " +
                    "counterintuitive," +
                    " journaling about tough feelings like anger and sadness lessens their intensity.");
    }

    public static Repo getInstance() {
        if (mInstance == null)
            mInstance = new Repo();
        return mInstance;
    }

    public void getRequest(final MyCallback<Letter> callback){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSucessfull(mLetter);
            }
        }, 2000);
    }


}
