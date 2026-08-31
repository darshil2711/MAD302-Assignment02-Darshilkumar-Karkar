/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date of Submission: 2025-01-30
 * Description: Detail screen for displaying full information about a selected product.
 */

package com.example.assignment02

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity that displays the full details of a selected [Product].
 */
class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product: Product? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("PRODUCT_KEY", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("PRODUCT_KEY")
        }

        if (product == null) {
            Toast.makeText(this, "Error: Product not found.", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        displayProductDetails(product)
    }

    private fun displayProductDetails(product: Product) {
        supportActionBar?.title = product.name

        val tvDetailName: TextView = findViewById(R.id.tvDetailName)
        val tvDetailPrice: TextView = findViewById(R.id.tvDetailPrice)
        val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)
        val tvDetailId: TextView = findViewById(R.id.tvDetailId)
        val btnBackToList: Button = findViewById(R.id.btnBackToList)

        tvDetailName.text = product.name
        tvDetailPrice.text = "Price: $${String.format("%.2f", product.price)}"
        tvDetailDescription.text = product.description
        tvDetailId.text = "Product ID: ${product.id}"

        btnBackToList.setOnClickListener {
            finish()
        }
    }
}
