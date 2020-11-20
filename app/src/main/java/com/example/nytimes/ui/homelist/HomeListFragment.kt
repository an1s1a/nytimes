package com.example.nytimes.ui.homelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.nytimes.R
import com.example.nytimes.adapter.ArticleAdapter
import com.example.nytimes.adapter.ArticleClickListener
import com.example.nytimes.databinding.FragmentHomeListBinding
import com.example.nytimes.ui.BaseFragment

class HomeListFragment : BaseFragment<HomeListViewModel>() {

    private lateinit var binding: FragmentHomeListBinding
    private val adapter = ArticleAdapter(ArticleClickListener {  })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)

        binding.viewmodel = viewModel
        binding.articleList.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticles()
    }

    override fun getViewModel(): Class<HomeListViewModel> {
        return HomeListViewModel::class.java
    }

    private fun getArticles() {
    }

}