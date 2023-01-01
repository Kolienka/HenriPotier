package com.example.henripotier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.fragments.BookDetails
import com.example.henripotier.fragments.BookList

class LibraryActivity : AppCompatActivity(), BookDetails.AddToBasketListener, BookList.Listener {

    private val bookDetails : BookDetails = BookDetails()
    private val bookList : BookList = BookList()
    private val basket : ArrayList<Book> = ArrayList()

    private lateinit var basketButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_library)
        basketButton = findViewById(R.id.basket_button)
        basketButton.setOnClickListener {
            val intent : Intent = Intent(this,LibraryActivity::class.java)
            startActivity(intent)
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.bookDetails, bookDetails)
            .replace(R.id.bookList, bookList)
            .commit()
    }

    override fun clickOnBook(book: Book) {
        bookDetails.updateBook(book)
    }

    override fun onBasketAddition(book: Book){
        basket.add(book)
        println(basket)
    }
}