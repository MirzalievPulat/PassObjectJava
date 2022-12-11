package com.example.passobjectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });

        User user = (User) getIntent().getParcelableExtra("user");
        Log.d(TAG,user.toString());

        text.setText(user.toString());
    }

    void openBack(){
        Intent intent = new Intent();
        intent.putExtra("result", "Thank You");
        setResult(RESULT_OK,intent);
        finish();
    }
}