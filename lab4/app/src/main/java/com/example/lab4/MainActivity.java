package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    Button start, pause, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player=MediaPlayer.create(this, R.raw.music);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        start = (Button) findViewById(R.id.button);
        pause = (Button) findViewById(R.id.button3);
        stop = (Button) findViewById(R.id.button2);
    }
    public void stopPlay(){
        player.stop();
        try {
            player.prepare();
            player.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view){

        player.start();
    }
    public void pause(View view){

        player.pause();
    }
    public void stop(View view){
        stopPlay();
    }
    @Override
    public void onDestroy() {
       super.onDestroy();
        if (player.isPlaying()) {
            stopPlay();
       }
    }
}
