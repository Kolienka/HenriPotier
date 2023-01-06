package com.example.henripotier.library.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.models.Book
import com.example.henripotier.library.BookAdapter
import com.example.henripotier.library.BookViewModel
import com.example.henripotier.R

class BookList : Fragment(), BookAdapter.OnBookClickListener {

    private val viewModel by viewModels<BookViewModel>()

    private lateinit var listener : Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context){
            is Listener -> listener = context
            else -> throw Exception("...")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_books, container, false)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        val orientation = if(context?.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayoutManager.HORIZONTAL
        }else{
            LinearLayoutManager.VERTICAL
        }
        recycleView.layoutManager = LinearLayoutManager(
            context,
            orientation,
            false
        )

        viewModel.state.observe(viewLifecycleOwner) { state ->
            recycleView.adapter = BookAdapter(state.books,this)
            if (state.books.isNotEmpty())
                listener.booksLoaded(state.books.first())
        }
        viewModel.loadBooks()
        return view
    }

    override fun onBookClick(book: Book) {
        listener.clickOnBook(book)
    }

    interface Listener{
        fun clickOnBook(book: Book)
        fun booksLoaded(book: Book)
    }
}