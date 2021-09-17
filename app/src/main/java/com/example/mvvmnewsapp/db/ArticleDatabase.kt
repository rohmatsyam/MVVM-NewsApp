package com.example.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.example.mvvmnewsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {

    abstract fun getArticleDao():ArticleDao

    companion object {
        @Volatile
        private var INSTANCE:ArticleDatabase? = null

        fun getDatabase(context: Context):ArticleDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }

    }
}