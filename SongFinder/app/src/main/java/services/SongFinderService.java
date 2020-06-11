package services;

import com.example.songfinder.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SongFinderService {

    public Retrofit initiateService() {
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
               .baseUrl(BuildConfig.BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(httpClient)
               .build();
    }
}
