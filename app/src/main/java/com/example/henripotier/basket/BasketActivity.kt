package com.example.henripotier.basket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.R
import com.example.henripotier.models.Book

class BasketActivity : AppCompatActivity() {

    companion object {
        internal const val BASKET = "BASKET"
    }

    private var basket: ArrayList<Book> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_activity)
        basket = intent.getParcelableArrayListExtra(BASKET)!! // à modifier car déprécié
        val recyclerView: RecyclerView = findViewById(R.id.basket_list)
        val adapter = BasketAdapter(basket)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
