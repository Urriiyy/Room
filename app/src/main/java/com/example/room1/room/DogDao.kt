package com.example.room1.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DogDao {

    @Query("Select * from dog")
    fun getAll(): LiveData<List<Dog>>


    @Insert(onConflict = REPLACE)
    suspend fun insert(dog: Dog)

    @Delete
    suspend fun delet(dog: Dog)
}