package com.example.mvvmtest.model;

public interface MyCallback<T> {
    void onSucessfull(T data);

    void onError (String message);
}
