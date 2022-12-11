package com.example.passobjectjava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.passobjectjava.model.User;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }
    void initviews(){
        text2 = findViewById(R.id.text);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Po'lat", "20");
                openSecondPage(user);
            }
        });
    }

    ActivityResultLauncher<Intent> secondLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        String text = data.getStringExtra("result");
                        Log.d(TAG,text);
                        text2.setText(text);
                    }
                }
            }
    );

    void openSecondPage(User user){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("user", user);
        secondLauncher.launch(intent);
    }
}