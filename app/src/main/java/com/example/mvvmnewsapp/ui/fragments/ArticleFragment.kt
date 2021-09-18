package com.example.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mvvmnewsapp.databinding.FragmentArticleBinding
import com.example.mvvmnewsapp.ui.NewsActivity
import com.example.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment:Fragment() {
    private lateinit var binding: FragmentArticleBinding
    private lateinit var viewModel: NewsViewModel
    val args:ArticleFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(layoutInflater)
        viewModel = (activity as NewsActivity).viewModel

        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        binding.fab.setOnClickListener {
            viewModel.savedArticle(article)
            Snackbar.make(binding.root,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
        }
        return binding.root
    }
}