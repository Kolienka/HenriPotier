package com.example.henripotier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.fragments.BookDetails
import com.example.henripotier.fragments.BookList

class LibraryActivity : AppCompatActivity(), BookDetails.Listener, BookList.Listener {

    private val bookDetails : BookDetails = BookDetails()
    private val bookList : BookList = BookList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.bookDetails, bookDetails)
            .replace(R.id.bookList, bookList)
            .commit()
    }
    override fun onBookSelected(book: Book) {
        TODO("Not yet implemented")
    }

    override fun clickOnBook(book: Book) {
        bookDetails.updateBook(book)
    }
}