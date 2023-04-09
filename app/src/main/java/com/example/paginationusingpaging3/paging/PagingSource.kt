package com.example.paginationusingpaging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationusingpaging3.model.Result
import com.user.unorg.network.ApiRoutes

/*
 * Created by : Himasnhu patel
 * Support :himanshu.patel@unorg.in
 * Last modified 3/25/23, 10:16 PM
 * Copyright (c) Unorg 2023.
 * All rights reserved.
 */
class PokeMonPagingSource(val api: ApiRoutes) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {



        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)?:   state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result>
    {
        try {
            val position = params.key ?: 1
            val response = api.getProducts(position, 10)
          //  val response = api.getAllProducts(position, 10)
            return LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.body()!!.count) null else position + 1
            )

        } catch (e: Exception) {
           return LoadResult.Error(e)
        }
    }
}