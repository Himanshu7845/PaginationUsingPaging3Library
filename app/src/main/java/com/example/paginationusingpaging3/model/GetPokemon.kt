package com.example.paginationusingpaging3.model

data class  GetPokemon(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)