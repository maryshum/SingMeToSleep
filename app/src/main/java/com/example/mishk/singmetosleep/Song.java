package com.example.mishk.singmetosleep;

import android.graphics.drawable.Drawable;

public class Song {
    //Name of the song
    private String mSongName;
    //Name of the artist
    private String mArtist;
    //ID of the drawable
    private int mAlbumArtResourceId;

    //Create a new Song object
    public Song (String songName, String artist, int albumArt){
        //@param songName is the name of the song
        //@param artist is the name of the artist performing the song
    //@param albumArt is drawable reference ID that corresponds to the Android version
        mSongName=songName;
        mArtist=artist;
        mAlbumArtResourceId=albumArt;
    }
    //Method to get the song name
    public String getSongName(){
        return mSongName;
    }
    //Method to get the name of the artist
    public String getArtistName(){
        return mArtist;
    }
    //Method to get the album art for the song
    public int getAlbumArtImage(){
        return mAlbumArtResourceId;
    }
}
