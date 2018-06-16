package com.example.mishk.singmetosleep;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        //get data from Intent passed from MainActivity
        String songName = getIntent().getStringExtra("Song_Name");
        String artistName = getIntent().getStringExtra("Artist");
        int albumImage = getIntent().getIntExtra("AlbumArt", 0);
        //find TextViews and ImageViews where the data should be placed and add data
        ImageView image = (ImageView) findViewById(R.id.nowplaying_albumart);
        image.setImageResource(albumImage);
        TextView title = (TextView)findViewById(R.id.playing_song_title);
        title.setText(songName);
        TextView artist = (TextView)findViewById(R.id.playing_song_artist);
        artist.setText(artistName);

        //Change Play button to Pause button when clicked
        //Reference used for this code: https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
        final Button playButton = (Button) findViewById(R.id.play);
        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                if( playButton.getTag().equals(1)){
                    playButton.setBackgroundResource(R.drawable.ic_pause_circle_outline);
                    playButton.setTag(2);
                }
                else {
                    playButton.setBackgroundResource(R.drawable.ic_play_circle_outline);
                    playButton.setTag(1);
            }
        }});
}}
