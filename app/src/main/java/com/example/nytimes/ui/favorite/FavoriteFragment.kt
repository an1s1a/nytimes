package com.example.nytimes.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.nytimes.R
import com.example.nytimes.databinding.FragmentFavoriteBinding
import com.example.nytimes.databinding.FragmentHomeListBinding
import com.example.nytimes.ui.BaseFragment
import com.example.nytimes.ui.homelist.HomeListViewModel

class FavoriteFragment : BaseFragment<FavoriteViewModel>() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)

        return binding.root
    }

    override fun getViewModel(): Class<FavoriteViewModel> {
        return FavoriteViewModel::class.java
    }

}