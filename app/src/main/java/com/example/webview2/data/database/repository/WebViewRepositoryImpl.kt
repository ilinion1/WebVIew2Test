package com.example.webview2.data.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.webview2.data.database.AppDatabase
import com.example.webview2.data.mapper.WebViewMapper
import com.example.webview2.data.network.api.ApiFactory
import com.example.webview2.domain.LinkContainer
import com.example.webview2.domain.WebViewRepository


class WebViewRepositoryImpl(private val application: Application) : WebViewRepository {

    private val webViewDao = AppDatabase.getInstance(application).webViewDao()
    private val mapper = WebViewMapper()
    private val apiService = ApiFactory.apiService

    override fun getLink(): LiveData<LinkContainer> {
        return Transformations.map(webViewDao.getLink()) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        val linkDto = apiService.loadLink()
        val linkDbModel = mapper.mapDtoToDbModel(linkDto)
        webViewDao.insertDatabase(linkDbModel)
    }
}