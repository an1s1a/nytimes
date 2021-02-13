package com.example.nytimes.ui.homelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.R
import com.example.nytimes.adapter.ArticleAdapter
import com.example.nytimes.adapter.ArticleClickListener
import com.example.nytimes.data.Result
import com.example.nytimes.databinding.FragmentHomeListBinding
import com.example.nytimes.ui.BaseFragment

class HomeListFragment : BaseFragment<HomeListViewModel>() {

    private var LOG_TAG = this::class.java.simpleName

    private lateinit var binding: FragmentHomeListBinding
    private val adapter = ArticleAdapter(ArticleClickListener { 
        article ->  viewModel.onArticleClicked(article)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)

        binding.viewmodel = viewModel

        getArticles()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.articleList.adapter = adapter

        viewModel.navigateToArticleDetail.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "article ${it.title}", Toast.LENGTH_LONG).show()
        })
    }

    override fun getViewModel(): Class<HomeListViewModel> {
        return HomeListViewModel::class.java
    }

    private fun getArticles() {
        viewModel.getArticles().observe(viewLifecycleOwner, Observer { articles ->
            when (articles.status) {
                Result.Status.SUCCESS -> adapter.submitList(articles.data!!.results)
                Result.Status.LOADING -> Log.e(LOG_TAG, "result $articles")
                Result.Status.ERROR -> Log.e(LOG_TAG, "result $articles")
            }
        })
    }

}