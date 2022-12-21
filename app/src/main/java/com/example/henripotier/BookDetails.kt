package com.example.henripotier

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import okhttp3.internal.http2.Http2Connection.Listener

class BookDetails : Fragment() {

    private lateinit var titleView : TextView

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

        return view
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