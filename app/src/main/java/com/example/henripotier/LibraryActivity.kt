package com.example.henripotier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LibraryActivity : AppCompatActivity(), BookDetails.Listener {

    private val viewModel by viewModels<LibraryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

        viewModel.state.observe(this) { state ->
            recycleView.adapter = BookAdapter(state.books)
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.bookDetails,BookDetails())
            .commit()


        viewModel.loadBooks()

    }
    override fun onBookSelected(book: Book) {
        TODO("Not yet implemented")
    }
}