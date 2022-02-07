package com.example.webview2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.webview2.R
import com.example.webview2.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WebViewViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.loadDataUseCase()
            starsFragment(WebViewFragment())
        }
    }

    private fun starsFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragContainer, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val webView = findViewById<WebView>(R.id.webView)
        if (webView.canGoBack()) {
            webView.goBack()
        } else super.onBackPressed()
    }
}