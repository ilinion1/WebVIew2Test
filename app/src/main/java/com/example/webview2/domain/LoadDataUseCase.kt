package com.example.webview2.domain

class LoadDataUseCase(private val repository: WebViewRepository) {

    suspend operator fun invoke() = repository.loadData()
}