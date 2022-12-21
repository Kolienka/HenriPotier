package com.example.henripotier

// A SUPPRIMER


import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class BookItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr){

    private lateinit var titleView: TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        titleView = findViewById(R.id.titleView)
    }

    fun bindView(book: Book){
        titleView?.text = book.title
    }

}