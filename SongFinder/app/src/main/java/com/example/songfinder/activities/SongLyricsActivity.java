package com.example.songfinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.songfinder.R;

public class SongLyricsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_lyrics);

        ScrollView scrollView = (ScrollView)findViewById(R.id.lyricsScrollView);
        TextView textView = (TextView)findViewById(R.id.lyricsTextView);

        String lyrics = getIntent().getStringExtra("lyrics");

        textView.setText(lyrics);
    }
}