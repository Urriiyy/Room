package com.example.room1.room

import androidx.lifecycle.LiveData

class DogRepository(var database: DbConnection) {
    var dogs: LiveData<List<Dog>> = database.dogDao().getAll()


    fun getAll(): LiveData<List<Dog>> {
        return dogs
    }

    suspend fun incert(dog: Dog) {
        database.dogDao().insert(dog)
    }

    suspend fun delete(dog: Dog){
        database.dogDao().delet(dog)
    }


}