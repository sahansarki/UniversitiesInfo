package com.sahan.universitiesinfo.viewmodel

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import com.sahan.universitiesinfo.fragment.DetailFragmentArgs

class DetailFragmentViewModel : ViewModel() {


    private lateinit var webPage: String

    fun showWebView(webView: WebView, args: DetailFragmentArgs) {

        webPage = args.selectedUniversity
        //webView.webViewClient = WebViewClient()


        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        //webView.settings.loadWithOverviewMode = true
        //webView.settings.useWideViewPort = true

        webView.loadUrl(webPage)

    }
}