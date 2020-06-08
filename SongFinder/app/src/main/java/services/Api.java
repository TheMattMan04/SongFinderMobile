package services;

import models.SongResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {
    @Headers("accept: application/json")
    @GET("/lyrics")
    Call<SongResponse> getSong(@Query("title") String title);

}
