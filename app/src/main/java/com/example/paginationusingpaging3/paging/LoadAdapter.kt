
package com.example.paginationusingpaging3.paging

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationusingpaging3.databinding.LoaderBinding
import com.example.paginationusingpaging3.databinding.SingleRowBinding
import com.example.paginationusingpaging3.model.Result

/*
 * Created by : Himanshu patel
 * Support :himanshu.patel@unorg.in
 * Last modified 3/25/23, 10:16 PM
 * Copyright (c) Unorg 2023.
 * All rights reserved.
 */

class LoadAdapter(
) : LoadStateAdapter<LoadAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: LoaderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState:LoadState) {
          binding.loader.isVisible=loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, loadState: LoadState) {
       holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): MyViewHolder {
        val binding = LoaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

}
