package com.example.henripotier.library

import com.example.henripotier.models.Book
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BookAdapterTest {

    private val mockListener = mockk<BookAdapter.OnBookClickListener>()
    private val mockBook = mockk<Book>()

    private lateinit var adapter: BookAdapter

    @Before
    fun setUp() {
        adapter = BookAdapter(listOf(mockBook), mockListener)
    }

    @Test
    fun testGetItemCount() {
        // Verify that the adapter returns the correct number of items
        assertEquals(1, adapter.itemCount)
    }

}
