/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date of Submission: 2026-04-22
 * Description: Main screen of the app. Displays a list of 7 products
 *              in a RecyclerView. Clicking a product navigates to the
 *              ProductDetailActivity using Intent, passing the product data.
 */

package com.example.assignment02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Main activity that displays the product list screen.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Product Catalog"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productList = createProductList()

        productAdapter = ProductAdapter(productList) { selectedProduct ->
            navigateToDetail(selectedProduct)
        }

        recyclerView.adapter = productAdapter
    }

    private fun navigateToDetail(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java).apply {
            putExtra("PRODUCT_KEY", product)
        }
        startActivity(intent)
    }

    private fun createProductList(): List<Product> {
        return listOf(
            Product(1, "Wireless Headphones", 89.99, "Premium over-ear headphones with ANC."),
            Product(2, "Mechanical Keyboard", 129.99, "75% mechanical keyboard with RGB."),
            Product(3, "USB-C Hub", 45.00, "7-in-1 hub with 100W PD."),
            Product(4, "Webcam 1080p", 74.99, "Full HD webcam with privacy shutter."),
            Product(5, "Portable Charger", 39.99, "20,000 mAh power bank."),
            Product(6, "Laptop Stand", 55.00, "Adjustable aluminum stand."),
            Product(7, "Smart Mouse", 62.50, "Ergonomic wireless mouse.")
        )
    }
}
