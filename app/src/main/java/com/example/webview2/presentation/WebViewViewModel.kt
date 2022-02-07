package com.example.webview2.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.webview2.data.database.AppDatabase
import com.example.webview2.data.network.api.ApiFactory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WebViewViewModel(application: Application) : AndroidViewModel(application) {


    private val compositeDisposable = CompositeDisposable()
    private val db = AppDatabase.getInstance(application)
    val getLink = db.webViewDao().getLink()

    fun loadData() {
        val disposable = ApiFactory.apiService.loadLink()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    db.webViewDao().insertDatabase(it)
                }, {
                    Log.d("MyLog", "${it.message}")
                }
            )
        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}