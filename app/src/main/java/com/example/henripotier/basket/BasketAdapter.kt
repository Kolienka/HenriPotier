package com.example.henripotier.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val quantityView: TextView = basketView.findViewById(R.id.quantity_value)
        val minusButton: Button = basketView.findViewById(R.id.minus_button)
        val plusButton: Button = basketView.findViewById(R.id.plus_button)

        var newPrice: Int = quantityView.text.toString().toInt()
        var quantity: Int = quantityView.text.toString().toInt()
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
        holder.minusButton.setOnClickListener{
            if (holder.quantity > 0) {
                holder.quantity--
                holder.originalPriceView.text = "Prix de base : " + (book.price*holder.quantity).toString() + " €"
                holder.offerPriceView.text = "Prix avec réduction : " + (book.price*holder.quantity) + "€"
                holder.quantityView.text = holder.quantity.toString()
            }
        }
        holder.plusButton.setOnClickListener{
            holder.quantity++
            holder.originalPriceView.text = "Prix de base : " + (book.price*holder.quantity).toString() + " €"
            holder.offerPriceView.text = "Prix avec réduction : " + (book.price*holder.quantity) + "€"
            holder.quantityView.text = holder.quantity.toString()
        }
        holder.titleView.text = book.title
        holder.originalPriceView.text = "Prix de base : " + (book.price*holder.quantity).toString() + " €"
        holder.offerPriceView.text = "Prix avec réduction : " + (book.price*holder.quantity) + "€"
    }

    override fun getItemCount(): Int = basket.size


}