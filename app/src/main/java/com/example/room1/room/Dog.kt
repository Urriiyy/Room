package com.example.room1.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog")
data class Dog(var name: String, var breed: String,){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


