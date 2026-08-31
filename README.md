# MAD302 - Assignment 02: Android Product List App

**Course:** MAD302-01 Android Development  
**Name:** Darshilkumar Karkar  
**Student ID:** A00203357  
**Date:** 2025-01-30

## Description
An Android app displaying 7 products in a RecyclerView. Tapping a product navigates to a detail screen via Intent using Parcelable data passing.

## Features
- RecyclerView with Adapter and ViewHolder pattern
- Lambda-based click handling
- Intent navigation between activities
- Parcelable data passing
- Null safety on Intent extras
- Back navigation support

## Project Structure
- `Product.kt` — Parcelable data class
- `ProductAdapter.kt` — RecyclerView adapter with lambda clicks
- `MainActivity.kt` — List screen with 7 products
- `ProductDetailActivity.kt` — Detail screen with null-safe data retrieval
- `item_product.xml` — Card layout for list rows
- `activity_product_detail.xml` — Detail screen layout

## How to Run
1. Clone: `git clone https://github.com/darshil2711/MAD302-Assignment02-Darshilkumar-Karkar`
2. Open in Android Studio
3. Run on emulator or device (min SDK 24)
