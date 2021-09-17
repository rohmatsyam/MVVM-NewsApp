package com.example.mvvmnewsapp.repository

import com.example.mvvmnewsapp.api.RetrofitInstance
import com.example.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(
    val db:ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}