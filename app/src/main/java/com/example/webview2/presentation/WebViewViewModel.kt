package com.example.webview2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.webview2.data.database.AppDatabase
import com.example.webview2.data.database.repository.WebViewRepositoryImpl

class WebViewViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = WebViewRepositoryImpl(application)
    private val db = AppDatabase.getInstance(application)
    val getLink = db.webViewDao().getLink()


    suspend fun loadData() {
        repository.loadData()
    }

}