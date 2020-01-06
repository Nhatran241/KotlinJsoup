package com.example.learnkotlin.Data

import com.example.kotlinjsoup.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
  private var retrofit: Retrofit? = null
  val apiService: GitHubService
    get() {
      if (retrofit == null) {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.freeforexapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
      }
      return retrofit!!.create(GitHubService::class.java)
    }
}