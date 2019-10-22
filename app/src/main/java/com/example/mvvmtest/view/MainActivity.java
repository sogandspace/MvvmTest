package com.example.mvvmtest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmtest.R;
import com.example.mvvmtest.model.Letter;
import com.example.mvvmtest.viewModel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private MyViewModel mMyViewModel;
    private TextView tvTitle, tvDes;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyViewModel.RequestData();
            }
        });

        mMyViewModel.getRecievedData().observe(this, new Observer<Letter>() {
            @Override
            public void onChanged(Letter letter) {
                tvTitle.setText(letter.getTitle());
                tvDes.setText(letter.getDes());
            }
        });

    }
}
