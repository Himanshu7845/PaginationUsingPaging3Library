package com.example.paginationusingpaging3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paginationusingpaging3.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private var repository: Repository) : ViewModel() {

    /*   private val getProductsMutableLiveData = MutableLiveData<GetPokemon>()
       val getProductsLiveData: LiveData<GetPokemon>
           get() = getProductsMutableLiveData
       val _error: SingleLiveEvent<String> = SingleLiveEvent()
       val error: LiveData<String>
           get() = _error

       val loading: SingleLiveEvent<Boolean> = SingleLiveEvent()
       val loadingLivedata: LiveData<Boolean>
           get() = loading
   */
    val result = repository.getPokemon().cachedIn(viewModelScope)
}