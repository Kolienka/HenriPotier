package com.example.henripotier.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.henripotier.models.Book
import com.example.henripotier.R
import com.example.henripotier.basket.BasketActivity
import com.example.henripotier.basket.BasketActivity.Companion.BASKET
import com.example.henripotier.library.fragments.BookDetails
import com.example.henripotier.library.fragments.BookList

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
            val intent = Intent(this@LibraryActivity, BasketActivity::class.java)
            intent.putParcelableArrayListExtra(BASKET,basket)
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

    override fun booksLoaded(book: Book) {
        bookDetails.updateBook(book)
    }


    override fun onBasketAddition(book: Book){
        basket.add(book)
    }
}