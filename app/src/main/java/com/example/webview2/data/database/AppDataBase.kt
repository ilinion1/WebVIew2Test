package com.example.webview2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LinkContainerDbModel::class], version =1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    companion object{
        private var db:AppDatabase? = null
        private val LOCK = Any()
        private const val NAME_DB = "main.db"

        fun getInstance(context: Context): AppDatabase{
            synchronized(LOCK){
                db?.let { return it }
                val instance = Room.databaseBuilder(context, AppDatabase::class.java,NAME_DB).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun webViewDao(): WebViewDao
}