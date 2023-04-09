package com.example.paginationusingpaging3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.paginationusingpaging3.adapter.HomeAdapter
import com.example.paginationusingpaging3.databinding.ActivityMainBinding

import com.example.paginationusingpaging3.network.showToast
import com.example.paginationusingpaging3.paging.LoadAdapter
import com.example.paginationusingpaging3.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val homeViewModel: HomeViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    lateinit var adapter: HomeAdapter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        adapter = HomeAdapter(this)
        binding.apply {
            rec.adapter = adapter.withLoadStateFooter(footer = LoadAdapter())
        }
        getData()
    }
    private fun getData() {

        homeViewModel.apply {
            result.observe(this@MainActivity, Observer {

                adapter.submitData(lifecycle,it)
            })
        }
    }
}