package com.example.kotlinjsoup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GitHubService {
  @GET("api/live?pairs=EURUSD")
  Call<Repo> listRepos();
}