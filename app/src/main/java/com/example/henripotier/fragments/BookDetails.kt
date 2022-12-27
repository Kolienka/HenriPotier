package com.example.henripotier.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.henripotier.Book
import com.example.henripotier.R
import com.squareup.picasso.Picasso

class BookDetails : Fragment() {

    private lateinit var titleView : TextView
    private lateinit var priceView : TextView
    private lateinit var synopsisView : TextView
    private lateinit var coverView : ImageView

    private lateinit var listener : Listener

    private var book: Book? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context) {
            is Listener -> listener = context
            else -> throw Exception("...")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_details,container,false)
        titleView = view.findViewById(R.id.titleView)
        priceView = view.findViewById(R.id.priceView)
        synopsisView = view.findViewById(R.id.synopsisView)
        coverView = view.findViewById(R.id.coverView)

        return view
    }

    fun updateBook(book : Book){
        Picasso.get()
            .load(book.cover)
            .into(coverView)
        titleView.text = book.title
        priceView.text = book.price.toString() + " €"
        var synopsis = StringBuilder()
        for(paragraph in book.synopsis){
            synopsis.append("\n")
            synopsis.append(paragraph)
        }
        synopsisView.text = synopsis.toString()
    }

    fun selectedBook(){
        book?.run {
            listener.onBookSelected(this)
        }
    }
    interface  Listener{
        fun onBookSelected(book: Book)
    }

}