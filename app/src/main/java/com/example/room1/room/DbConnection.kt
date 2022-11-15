package com.example.room1.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dog::class], version = 1)
abstract class DbConnection: RoomDatabase(){
    abstract fun dogDao(): DogDao
}