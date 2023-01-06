package com.example.henripotier.library

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.henripotier.RetrofitSingleton
import com.example.henripotier.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel : ViewModel() {

    val state = MutableLiveData<BookState>()

    fun loadBooks(){
        val service : Service = RetrofitSingleton.getInstance.create(Service::class.java)
        state.postValue(BookState(emptyList(), true))
        viewModelScope.launch(context = Dispatchers.Main){
            val books = withContext(Dispatchers.IO){
                service.books()
            }
            state.postValue(BookState(books,false))
        }
    }
}