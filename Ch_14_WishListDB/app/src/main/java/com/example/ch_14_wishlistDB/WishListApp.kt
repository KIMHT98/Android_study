package com.example.ch_14_wishlistDB

import android.app.Application

class WishListApp:Application() {

    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}