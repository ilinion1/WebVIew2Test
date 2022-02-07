package com.example.webview2.data.network.api

import com.example.webview2.data.network.api.model.LinkContainerDto
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(KEY)
    suspend fun loadLink(): LinkContainerDto

    companion object{
        const val KEY = "prod"
    }

}