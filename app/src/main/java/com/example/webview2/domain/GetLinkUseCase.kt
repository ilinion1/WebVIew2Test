package com.example.webview2.domain

class GetLinkUseCase(private val repository: WebViewRepository) {

    operator fun invoke() = repository.getLink()

}