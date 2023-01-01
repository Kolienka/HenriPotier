package com.example.henripotier.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.henripotier.Book
import com.example.henripotier.R
import com.squareup.picasso.Picasso

class BookDetails : Fragment(){

    private lateinit var titleView : TextView
    private lateinit var priceView : TextView
    private lateinit var synopsisView : TextView
    private lateinit var coverView : ImageView
    private lateinit var buttonView : Button
    private lateinit var quantityPicker : NumberPicker

    private val confirmationDialog = Confirmation()

    private lateinit var listener : AddToBasketListener

    private lateinit var book: Book

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context) {
            is AddToBasketListener -> listener = context
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
        buttonView = view.findViewById(R.id.add_to_basket)
        return view
    }

    fun updateBook(book : Book){
        this.book = book
        Picasso.get()
            .load(book.cover)
            .placeholder(R.drawable.progress_animation)
            .resize(320,512)
            .into(coverView)
        titleView.text = book.title
        priceView.text = book.price.toString() + " €"
        var synopsis = StringBuilder()
        for(paragraph in book.synopsis){
            synopsis.append(paragraph)
            synopsis.append("\n")
        }
        synopsisView.text = synopsis.toString()
        buttonView.setOnClickListener{
            listener.onBasketAddition(book)
        }
    }
    interface  AddToBasketListener{
        fun onBasketAddition(book: Book)
    }
}

interface GetQuantityListener{
    fun onQuantityPassed(n: Int)
}




