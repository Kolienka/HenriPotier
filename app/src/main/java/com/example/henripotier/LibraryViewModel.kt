package com.example.henripotier

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

data class LibraryState(
    val books: List<Book> = emptyList(),
    val isLoading: Boolean
)

class LibraryViewModel : ViewModel() {

    fun loadBooks(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service : Service = retrofit.create(Service::class.java)

        state.postValue(LibraryState(emptyList(), true))

        viewModelScope.launch(context = Dispatchers.Main){
            val books = withContext(Dispatchers.IO){
                service.books()
            }
            state.postValue(LibraryState(books,false))
        }
    }
    val state = MutableLiveData<LibraryState>()
}