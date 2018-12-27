package com.example.localadmin.mymediaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.content.ContentUris;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myBtnOpen;
    Button myBtnPlay;

    final Uri DATA_URI = ContentUris
            .withAppendedId(
                    android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    13359);
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

        Uri myUri = "/"; // initialize Uri here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(getApplicationContext(), myUri);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    public void onPlayButtonClick(View view) {
        myTextView.setText("не Все ок)");
    }
}
