package com.example.henripotier.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.Book
import com.example.henripotier.BookAdapter
import com.example.henripotier.LibraryViewModel
import com.example.henripotier.R

class BookList : Fragment(), BookAdapter.OnBookClickListener {

    private val viewModel by viewModels<LibraryViewModel>()

    private lateinit var recyclerView : RecyclerView
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
        recyclerView = view.findViewById(R.id.recycleView)
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
        }
        viewModel.loadBooks()
        return view
    }

    override fun onBookClick(book: Book) {
        listener.clickOnBook(book)
    }

    interface Listener{
        fun clickOnBook(book: Book)
    }
}