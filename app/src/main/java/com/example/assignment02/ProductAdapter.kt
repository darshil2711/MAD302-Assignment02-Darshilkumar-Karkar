/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 */

package com.example.assignment02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 */
class ProductAdapter(
    private val products: List<Product>,
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
    }

}
