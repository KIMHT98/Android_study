package com.example.ch_14_wishlistDB.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String="",
    @ColumnInfo(name = "wish-desc")
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