package com.example.henripotier.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.henripotier.R

class Confirmation : DialogFragment() {

    private lateinit var quantity : NumberPicker
    private lateinit var cancelButton : Button
    private lateinit var confirmButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.confirmation_dialog,container,false)

        quantity = view.findViewById(R.id.quantity)
        quantity.minValue = 0
        quantity.maxValue = 10
        quantity.wrapSelectorWheel = true
        quantity.value = 0

        cancelButton = view.findViewById(R.id.cancel_button)
        cancelButton.setOnClickListener {
            this.dismiss()
        }

        confirmButton = view.findViewById(R.id.confirm_button)
        confirmButton.setOnClickListener {
            passQuantity(quantity.value)
            Toast.makeText(context,"Confirmation ajout panier", Toast.LENGTH_LONG)
            this.dismiss()
        }

        return view
    }

    fun passQuantity(n: Int){
        (activity as? GetQuantityListener)?.onQuantityPassed(n)
    }

}