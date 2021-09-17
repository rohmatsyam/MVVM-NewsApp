package com.example.mvvmnewsapp.api

import com.example.mvvmnewsapp.NewsResponse
import com.example.mvvmnewsapp.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String = "id",
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apiKey:String = Constant.API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apiKey:String = Constant.API_KEY
    ):Response<NewsResponse>
}