package com.example.mishk.singmetosleep;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String songName;
    String artist;
    int albumArtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        //Create an ArrayList of Songs
        ArrayList<Song> listOfSongs = new ArrayList<Song>();
        listOfSongs.add(new Song("Lullaby","NaviBand", R.drawable.navi));
        listOfSongs.add(new Song("Troubadour`s ballad", "Muslim Magomaev", R.drawable.troubadour));
        listOfSongs.add(new Song("Clair De Lune", "Claude Debussy", R.drawable.debussy));
        listOfSongs.add(new Song ("Lullaby", "Johannes Brahms", R.drawable.brahms));
        listOfSongs.add(new Song ("Hush Little Baby", "Joanie Bartels", R.drawable.bartels));
        listOfSongs.add(new Song("When you wish upon a star","Jimmy Cricket", R.drawable.cricket));
        listOfSongs.add(new Song("Ah, vous dirais-je maman", "W.A.Mozart", R.drawable.mozart));
        listOfSongs.add(new Song("Kalychanka", "Yadzviga Paplayskaya",R.drawable.kalychanka));
        listOfSongs.add(new Song("Tu Tu Teshcote", "Lorain Fox", R.drawable.teshcote));
        listOfSongs.add(new Song("Umka`s lullaby","Aida Vedisheva", R.drawable.umka ));

        //create an adapter with data source ArrayList<Song>
        final SongAdapter adapter = new SongAdapter(this, listOfSongs);
        //find a ListView and set adapter on ListView
        ListView songs = findViewById(R.id.list);
        songs.setAdapter(adapter);

        //Set OnClickListener for ListView items and create Intent for transferring data between activities
        //Reference used for this code: https://stackoverflow.com/questions/3184672/what-does-adapterview-mean-in-the-onitemclick-method-what-is-the-use-of-ot
        // Create a click handling object as an anonymous class.
        songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@param AdapterView is the view where the click happened (e.g. ListView)
            //@param View is the item of the view that was clicked
            //@param position is the position of the item in the view
            //@param long id is the row id of the item that is clicked
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Get the data item associated with the specified position from adapter and store it in the new Song object
                Song info = (Song) adapter.getItem(position);
                //create new Intent
                Intent openNowPlayingActivity = new Intent(MainActivity.this, NowPlayingActivity.class);
                //add extra data for passing to NowPlayingActivity by calling corresponding methods on Song object
                openNowPlayingActivity.putExtra("Song_Name",info.getSongName());
                openNowPlayingActivity.putExtra("Artist", info.getArtistName());
                openNowPlayingActivity.putExtra("AlbumArt", info.getAlbumArtImage());
                startActivity(openNowPlayingActivity);
            }
        });
    }


}
