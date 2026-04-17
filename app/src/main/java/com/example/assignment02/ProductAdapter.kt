/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date of Submission: 2026-04-22
 * Description: RecyclerView Adapter for displaying a list of Product items.
 *              Uses the ViewHolder pattern and lambda-based click handling.
 */

package com.example.assignment02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Adapter for binding a list of [Product] objects to item views.
 *
 * Uses a lambda function for click handling so the calling Activity
 * can define what happens when a product is tapped.
 *
 * @param products The list of products to display.
 * @param onItemClick Lambda function called when a product item is clicked.
 *                    Receives the clicked [Product] as a parameter.
 */
class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit  // Lambda for click handling
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder class that holds references to the views in each list item.
     *
     * Caches the views to avoid calling findViewById repeatedly during scrolling.
     *
     * @param itemView The inflated view for one product row.
     */
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Cache view references for performance
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvProductDescription: TextView = itemView.findViewById(R.id.tvProductDescription)
    }

    /**
     * Called by RecyclerView to create a new ViewHolder when needed.
     *
     * Inflates the item layout and returns a [ProductViewHolder].
     *
     * @param parent The ViewGroup into which the new view will be added.
     * @param viewType The view type of the new View (unused here, single type).
     * @return A new [ProductViewHolder] holding the inflated view.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Inflate the item layout for a single product row
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    /**
     * Called by RecyclerView to display data for a specific position.
     *
     * Binds the [Product] at [position] to the views inside the [holder].
     * Also sets up the lambda-based click listener.
     *
     * @param holder The [ProductViewHolder] that should be updated.
     * @param position The position of the item in the data set.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        // Bind product data to views
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = "$${String.format("%.2f", product.price)}"
        holder.tvProductDescription.text = product.description

        // Lambda-based click listener — passes the clicked product to the caller
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    /**
     * Returns the total number of items in the data set.
     *
     * @return Size of the products list.
     */
    override fun getItemCount(): Int = products.size
}
