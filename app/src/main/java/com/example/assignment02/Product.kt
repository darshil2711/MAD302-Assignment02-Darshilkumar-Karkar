/*
 * Course: MAD302-01 Android Development
 * Assignment: Assignment 2 - Product List with RecyclerView
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date of Submission: 2026-04-22
 * Description: Data class representing a product with name, price, and description.
 *              Implements Parcelable so it can be passed between Activities via Intent.
 */

package com.example.assignment02

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class representing a single product.
 *
 * Implements [Parcelable] to allow passing between activities using Intent extras.
 *
 * @property id Unique identifier for the product.
 * @property name The display name of the product.
 * @property price The price of the product in dollars.
 * @property description A short description of the product.
 * @property imageRes Optional drawable resource ID for the product image.
 */
@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageRes: Int = 0
) : Parcelable
