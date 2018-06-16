package com.example.mishk.singmetosleep;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//Reference used for this code: https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
public class SongAdapter extends ArrayAdapter<Song> {
    //Creating custom constructor that holds a view, which will be used to inflate the list layout, (Activity, referred to as context)
    // and ArrayList with songs
    public SongAdapter (Activity context, ArrayList<Song> listOfSongs){
        //the second argument is used only when adapter creates a single TextView, so we set it to 0, because current adapter creates three views
        super(context, 0, listOfSongs);
    }
    /** Providing a view for Adapder
     * @param position The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
         //Get Song object located at this position in the list
        Song currentSong = getItem(position);
        //Find TextView for Song Name
        TextView songName = (TextView) listItemView.findViewById (R.id.song_name);
        //Get SongName from current object and pass it to TextView
        songName.setText(currentSong.getSongName());
        //Find TextView for Artist Name
        TextView artist = (TextView) listItemView.findViewById(R.id.artist_name);
        //Get Artist Name from current object and pass it to TextView
        artist.setText(currentSong.getArtistName());
        //Find ImageView for Album Art for current song
        ImageView albumArt = (ImageView) listItemView.findViewById(R.id.album_art);
        //get Album art from current object and pass it to ImageView
        albumArt.setImageResource(currentSong.getAlbumArtImage());
        //return the given layout
        return listItemView;
    }
}
