
package com.example.paginationusingpaging3.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationusingpaging3.databinding.SingleRowBinding
import com.example.paginationusingpaging3.model.Result

/*
 * Created by : Himanshu patel
 * Support :himanshu.patel@unorg.in
 * Last modified 3/25/23, 10:16 PM
 * Copyright (c) Unorg 2023.
 * All rights reserved.
 */

class HomeAdapter(
    val context: Context,
) :

    PagingDataAdapter<Result, HomeAdapter.MyViewHolder>(MyDiffUtilsProducts()) {
    inner class MyViewHolder(val binding: SingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: com.example.paginationusingpaging3.model.Result, context: Context, position: Int) {
          binding.setData=product
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            SingleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Product = getItem(position)
        Log.d("getDataProduct", "onBindViewHolder: ${Product.toString()}")
        holder.bind(Product!!, context, position)

    }
}

class MyDiffUtilsProducts : DiffUtil.ItemCallback<com.example.paginationusingpaging3.model.Result>() {
    override fun areItemsTheSame(
        oldItem: com.example.paginationusingpaging3.model.Result,
        newItem: com.example.paginationusingpaging3.model.Result
    ): Boolean {
        return oldItem.name == newItem.name

    }

    override fun areContentsTheSame(
        oldItem: com.example.paginationusingpaging3.model.Result,
        newItem: com.example.paginationusingpaging3.model.Result
    ): Boolean {
        return oldItem == newItem
    }

}
