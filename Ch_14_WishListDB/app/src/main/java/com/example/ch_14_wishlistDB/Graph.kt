package com.example.ch_14_wishlistDB

import android.content.Context
import androidx.room.Room
import com.example.ch_14_wishlistDB.data.WishDatabase
import com.example.ch_14_wishlistDB.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy{
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}