package com.example.passobjectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.passobjectjava.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }
    void initviews(){
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Po'lat", "20");
                openSecondPage(user);
            }
        });
    }
    void openSecondPage(User user){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}