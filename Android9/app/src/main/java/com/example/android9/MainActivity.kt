package com.example.android9

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity :AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            webView = findViewById(R.id.webView)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = MyWebViewClient()
            webView.loadUrl("https://www.youtube.com")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error initiallizing webView", e)

        }

    }

    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?, request: WebResourceRequest?
        ): Boolean {
            request?.url?.let {
                view?.loadUrl(it.toString())
                return true
            }
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}
