package com.example.henripotier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LibraryActivity : AppCompatActivity() {

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

        viewModel.loadBooks()

    }

}