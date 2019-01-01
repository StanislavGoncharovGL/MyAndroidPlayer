/*
https://startandroid.ru/ru/uroki/vse-uroki-spiskom/236-urok-126-media-mediaplayer-audiovideo-pleer-osnovnye-vozmozhnosti.html
 */

package com.example.localadmin.mymediaapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myBtnOpen;
    Button myBtnPlay;
    Uri uri;
    MediaPlayer mediaPlayer;

    private static final int REQUEST_PICK_AUDIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uri = null;
        mediaPlayer = null;
        myTextView = findViewById(R.id.textView);
        myBtnOpen = findViewById(R.id.open);
        myBtnPlay = findViewById(R.id.play);
    }

    public void onOpenButtonClick(View view) {
        Intent intent = new Intent();
        intent.setType("audio/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Audio "), REQUEST_PICK_AUDIO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        releaseMP();

        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    uri = data.getData();

                    try {
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(this, uri);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        myBtnPlay.setText("Pause");
                    } catch (Exception e) {
                        myTextView.setText("onActivityResult Exeption");
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    public void onPlayButtonClick(View view) {
        if (mediaPlayer == null) {
            myTextView.setText("не Все ок)");
            return;
        }

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            myBtnPlay.setText("Pause");
        } else {
            mediaPlayer.pause();
            myBtnPlay.setText("Play");
        }
    }

    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                myTextView.setText("releaseMP Exeption");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }
}
