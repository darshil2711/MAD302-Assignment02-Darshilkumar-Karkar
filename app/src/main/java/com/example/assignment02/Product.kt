/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date of Submission: 2025-01-30
 * Description: Data class representing a product with name, price, and description.
 */

package com.example.assignment02

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class representing a single product.
 */
@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageRes: Int = 0
) : Parcelable
