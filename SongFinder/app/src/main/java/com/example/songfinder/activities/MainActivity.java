package com.example.songfinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.songfinder.R;

import models.Genius;
import models.Song;
import models.SongResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.Api;
import services.SongFinderService;

public class MainActivity extends AppCompatActivity {
    private String inputSongText;
    private String songSearchedText;
    private String songTitle;
    private EditText songTitleEditText;
    private SongFinderService songFinderService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songFinderService = new SongFinderService();

        inputSongText = getResources().getString(R.string.input_song_text);
        songSearchedText = getResources().getString(R.string.song_searched);

        songTitleEditText = (EditText)findViewById(R.id.songTitleEditText);
        songTitleEditText.setHint("Search");
    }

    public void setSongTitle(View view) {

    }

    public void searchSongText(View view) {
        songSearchedText = songTitleEditText.getText().toString();
        songTitle = songSearchedText;

        Retrofit service = songFinderService.initiateService();
        Api api = service.create(Api.class);
        Call<SongResponse> call = api.getSong(songTitle);

        call.enqueue(new Callback<SongResponse>() {
            @Override
            public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                try {
                    String title = response.body().getTitle();
                    String author = response.body().getAuthor();
                    String lyrics = response.body().getLyrics();
                    Genius thumbnail = response.body().getThumbnail();
                    Genius links = response.body().getLinks();

                    Song song = new Song(title,
                            author,
                            lyrics,
                            thumbnail.getGenius(),
                            links.getGenius()
                    );

                    Intent intent = new Intent(MainActivity.this, SongSearchActivity.class);
                    intent.putExtra("title", song.getTitle());
                    intent.putExtra("artist", song.getAuthor());
                    intent.putExtra("image", song.getThumbnail());
                    intent.putExtra("lyrics", song.getLyrics());

                    startActivity(intent);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SongResponse> song, Throwable t) {
                Log.d("Error: ", t.getMessage());
            }
        });
    }
}