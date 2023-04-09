/*
 * Created by : Tanishq Chawda on 3/25/23, 9:25 PM
 * Support :itanishqdeveloper@gmail.com
 * Last modified 3/25/23, 9:25 PM
 * Copyright (cart) Unorg 2023.
 * All rights reserved.
 */

package com.user.unorg.network


import com.example.paginationusingpaging3.model.DTO
import com.example.paginationusingpaging3.model.GetPokemon
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiRoutes
{
    @GET("pokemon")
    suspend fun getProducts(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ):Response<GetPokemon>

    @POST("products")
    suspend fun getAllProducts(
     @Body dto: DTO
    ):Response<GetPokemon>

}