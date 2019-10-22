package com.example.mvvmtest.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtest.model.Letter;
import com.example.mvvmtest.model.MyCallback;
import com.example.mvvmtest.model.Repo;

import javax.security.auth.callback.Callback;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<Letter> mRecievedData;
    private Repo mRepo;

    public MyViewModel(@NonNull Application application) {
        super(application);
        mRecievedData = new MutableLiveData<>();

        mRepo = new Repo();
    }

    public void RequestData () {
        mRepo.getRequest(new MyCallback<Letter>() {

            @Override
            public void onSucessfull(Letter data) {
                mRecievedData.setValue(data);

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public MutableLiveData<Letter> getRecievedData() {
        return mRecievedData;
    }
}
