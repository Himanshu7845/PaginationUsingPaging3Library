package com.example.paginationusingpaging3.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.example.newprojects.resultwrapper.ApiUtils
import com.example.paginationusingpaging3.model.GetPokemon
import com.example.paginationusingpaging3.paging.PokeMonPagingSource
import com.unorg.unorg.models.ApiResult
import com.user.unorg.network.ApiRoutes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/*
 * Created by : Himasnhu patel
 * Support :himanshu.patel@unorg.in
 * Last modified 3/25/23, 10:16 PM
 * Copyright (c) Unorg 2023.
 * All rights reserved.
 */

class Repository @Inject constructor(
    private val apiInterFace: ApiRoutes,
    private val apiUtils: ApiUtils,
    @ApplicationContext private val context: Context
) {
    /*suspend fun getPokemon(offset: Int, limit: Int): ApiResult<GetPokemon> {
        return apiUtils.getResponse(context, "Oops Something went wrong") {
            apiInterFace.getProducts(offset, limit)
        }
    }*/
    fun getPokemon()=Pager(
        config = PagingConfig(10,10),
        pagingSourceFactory = {
            PokeMonPagingSource(apiInterFace)
        }
    ).liveData
}