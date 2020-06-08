package com.example.songfinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private String songTitle;
    private EditText songTitleEditText;
    private Button searchButton;
    private SongFinderService songFinderService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songFinderService = new SongFinderService();

        songTitleEditText = (EditText)findViewById(R.id.songTitleEditText);
        songTitleEditText.setHint(R.string.input_song_text);

        searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setText(R.string.find_song_text);
    }

    public void searchSongText(View view) {
        songTitle = songTitleEditText.getText().toString();
        searchButton.setText(R.string.searching_song);

        Retrofit service = songFinderService.initiateService();
        Api api = service.create(Api.class);
        Call<SongResponse> call = api.getSong(songTitle);

        if (!songTitle.equals("")) {
            call.enqueue(new Callback<SongResponse>() {
                @Override
                public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                    if (response.isSuccessful()) {
                        Log.d("Response : ", response.toString());

                        if (response.body().getError() != null) {
                            searchButton.setText(R.string.find_song_text);
                            Toast.makeText(MainActivity.this, R.string.song_not_found, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String title = response.body().getTitle();
                            String author = response.body().getAuthor();
                            String lyrics = response.body().getLyrics();
                            Genius thumbnail = response.body().getThumbnail();
                            Genius links = response.body().getLinks();

                            Log.d("Response: ", response.body().toString());

                            Song song = new Song(title,
                                    author,
                                    lyrics,
                                    thumbnail.getGenius(),
                                    links.getGenius(),
                                    null
                            );

                            Intent intent = new Intent(MainActivity.this, SongSearchActivity.class);
                            intent.putExtra("title", song.getTitle());
                            intent.putExtra("artist", song.getAuthor());
                            intent.putExtra("image", song.getThumbnail());
                            intent.putExtra("lyrics", song.getLyrics());

                            startActivity(intent);
                        }

                        searchButton.setText(R.string.find_song_text);
                    }
                    else {
                        Toast.makeText(MainActivity.this, R.string.song_not_found, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SongResponse> song, Throwable t) {
                    searchButton.setText(R.string.find_song_text);
                    Toast.makeText(MainActivity.this, R.string.error_occurred, Toast.LENGTH_SHORT).show();
                    Log.d("Error: ", t.toString());
                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, R.string.empty_title, Toast.LENGTH_SHORT).show();
            searchButton.setText(R.string.find_song_text);
        }
    }
}