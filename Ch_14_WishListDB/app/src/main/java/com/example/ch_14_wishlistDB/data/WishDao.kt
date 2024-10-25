package com.example.ch_14_wishlistDB.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wish:Wish)
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>
    @Update
    abstract suspend fun updateAWish(wishEntity:Wish)
    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)
    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long):Flow<Wish>
}