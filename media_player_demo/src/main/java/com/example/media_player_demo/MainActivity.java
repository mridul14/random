package com.example.media_player_demo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    private boolean isPlaying;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        player = MediaPlayer.create(MainActivity.this, R.raw.low_fast);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPlaying){
                    stopSong(fab);
                }else{
                    playSong(fab);
                }


            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isPlaying){
            stopSong(fab);
        }
    }

    private void playSong(FloatingActionButton fab) {
        player = MediaPlayer.create(MainActivity.this, R.raw.low_fast);
        player.start();
        fab.setImageResource(R.drawable.ic_stop_black_24dp);
        isPlaying = true;
    }

    private void stopSong(FloatingActionButton fab){
        if(player!=null){
           if (player.isPlaying()){
               player.stop();

               fab.setImageResource(R.drawable.ic_play_arrow_black_24dp);
               isPlaying=false;
           }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
