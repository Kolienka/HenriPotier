package com.example.henripotier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(bookView: View) : RecyclerView.ViewHolder(bookView){
        val titleView: TextView = bookView.findViewById(R.id.titleView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val bookView = LayoutInflater.from(parent.context).inflate(R.layout.custom_view_item_book,parent,false)
        return BookViewHolder(bookView)
    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleView.text = book.title
    }
    override fun getItemCount(): Int = books.size
}

