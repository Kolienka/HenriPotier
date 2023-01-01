package com.example.henripotier.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.henripotier.R
import com.example.henripotier.models.Book
import com.squareup.picasso.Picasso

class BasketAdapter(private val basket: List<Book>) : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    class BasketViewHolder(basketView : View) : RecyclerView.ViewHolder(basketView){
        val coverView: ImageView = basketView.findViewById(R.id.item_cover_view)
        val titleView: TextView = basketView.findViewById(R.id.item_title)
        val originalPriceView: TextView = basketView.findViewById(R.id.original_price)
        val offerPriceView: TextView = basketView.findViewById(R.id.offer_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val basketView = LayoutInflater.from(parent.context).inflate(R.layout.custom_view_item_basket,parent,false)
        return BasketViewHolder(basketView)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val book = basket[position]
        Picasso.get()
            .load(book.cover)
            .placeholder(R.drawable.progress_animation)
            .resize(320,512)
            .into(holder.coverView)
        holder.titleView.text = book.title
        holder.originalPriceView.text = book.price.toString() + " €"
        holder.offerPriceView.text = book.price.toString() + "€"
    }

    override fun getItemCount(): Int = basket.size


}