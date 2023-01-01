package com.example.henripotier

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookViewModel : ViewModel() {

    val state = MutableLiveData<BookState>()

    private fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun loadBooks(){
        val service : Service = getRetrofit().create(Service::class.java)
        state.postValue(BookState(emptyList(), true))
        viewModelScope.launch(context = Dispatchers.Main){
            val books = withContext(Dispatchers.IO){
                service.books()
            }
            state.postValue(BookState(books,false))
        }
    }
}