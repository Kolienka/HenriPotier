package com.example.henripotier.basket

import com.example.henripotier.models.Book
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BasketAdapterTest {

    private lateinit var basket: List<Book>
    private lateinit var adapter: BasketAdapter

    @Before
    fun setUp() {
        // Create a list of mock books and initialize the adapter
        basket = listOf(
            Book(isbn = "isbn", title = "Book 1", price = 10, synopsis= listOf("The great synopsis of", "Book 1"), cover = "cover1.jpg"),
            Book(isbn = "isbn", title = "Book 2", price = 20, synopsis= listOf("The great synopsis of", "Book 2"), cover = "cover2.jpg")
        )
        adapter = BasketAdapter(basket)
    }

    @Test
    fun testGetItemCount() {
        // The adapter should have the same number of items as the list of books
        assertEquals(basket.size, adapter.itemCount)
    }
}
