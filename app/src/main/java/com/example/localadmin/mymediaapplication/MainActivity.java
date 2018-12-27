package com.example.localadmin.mymediaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myBtnOpen;
    Button myBtnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.textView);
        myBtnOpen = (Button) findViewById(R.id.open);
        myBtnPlay = (Button) findViewById(R.id.play);
    }

    public void onOpenButtonClick(View view) {
        myTextView.setText("Все ок)");
    }

    public void onPlayButtonClick(View view) {
        myTextView.setText("не Все ок)");
    }
}
