package com.example.webview2.data.network.api

import com.example.webview2.data.network.model.LinkContainerDto
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(KEY)
    fun loadLink(): Single<LinkContainerDto>

    companion object{
        const val KEY = "prod"
    }

}