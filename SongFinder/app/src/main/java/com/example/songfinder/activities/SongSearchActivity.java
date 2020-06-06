package com.example.songfinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songfinder.R;
import com.squareup.picasso.Picasso;

public class SongSearchActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_search_result);

        ImageView imageView = (ImageView)findViewById(R.id.songImageView);
        TextView textView = (TextView)findViewById(R.id.songTextView);

        String songTitle = getIntent().getStringExtra("title");
        String songArtist = getIntent().getStringExtra("artist");
        String songImage = getIntent().getStringExtra("image");

        Picasso.get().load(songImage).into(imageView);

        textView.setText("Artist: ".concat(songArtist) + '\n' + '\n' +
                        "Title: ".concat(songTitle));
    }

    public void backToSearch(View view) {
        Intent intent = new Intent(SongSearchActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void getLyrics(View view) {
        String lyrics = getIntent().getStringExtra("lyrics");

        Intent intent = new Intent(SongSearchActivity.this, SongLyricsActivity.class);
        intent.putExtra("lyrics", lyrics);

        startActivity(intent);
    }
}