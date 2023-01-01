package com.example.henripotier.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.R
import com.example.henripotier.models.Book

class BookAdapter(private val books: List<Book>, private val listener : OnBookClickListener) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(bookView: View) : RecyclerView.ViewHolder(bookView){
        val titleView: Button = bookView.findViewById(R.id.titleView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val bookView = LayoutInflater.from(parent.context).inflate(R.layout.custom_view_item_book,parent,false)
        return BookViewHolder(bookView)
    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleView.setOnClickListener{
            listener.onBookClick(book)
        }
        holder.titleView.text = book.title
    }

    override fun getItemCount(): Int = books.size

    interface OnBookClickListener{
        fun onBookClick(book : Book)
    }

}

