package com.example.ch_13_wishlist.data

data class Wish(
    val id: Long = 0L,
    val title: String="",
    val description: String=""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 1", description = "An android Watch1"),
        Wish(title = "Google Watch 2", description = "An android Watch2"),
        Wish(title = "Google Watch 3", description = "An android Watch3"),
        Wish(title = "Google Watch 4", description = "An android Watch4"),

    )
}