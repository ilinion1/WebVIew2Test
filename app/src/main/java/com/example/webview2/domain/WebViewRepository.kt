package com.example.webview2.domain

import androidx.lifecycle.LiveData

interface WebViewRepository {

    fun getLink(): LiveData<LinkContainer>

    suspend fun loadData()
}