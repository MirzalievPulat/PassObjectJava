package com.example.passobjectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.passobjectjava.model.User;

public class SecondActivity extends AppCompatActivity {
    static final String TAG = SecondActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initviews();
    }

    void initviews(){
        TextView text = findViewById(R.id.text);

        User user = (User) getIntent().getParcelableExtra("user");
        Log.d(TAG,user.toString());

        text.setText(user.toString());
    }
}