package com.example.webview2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.webview2.data.database.repository.WebViewRepositoryImpl
import com.example.webview2.domain.GetLinkUseCase
import com.example.webview2.domain.LoadDataUseCase

class WebViewViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WebViewRepositoryImpl(application)
    val getLinkUseCase = GetLinkUseCase(repository)
    val loadDataUseCase = LoadDataUseCase(repository)

}