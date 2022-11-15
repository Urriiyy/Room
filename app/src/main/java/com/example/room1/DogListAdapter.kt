package com.example.room1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room1.databinding.DogItemBinding

import com.example.room1.room.Dog

class DogListAdapter: RecyclerView.Adapter<DogListAdapter.ViewHolder>() {

    var dogs: List<Dog> = mutableListOf()

    fun updateList(dogs: List<Dog>){
        this.dogs = dogs
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: DogItemBinding = DogItemBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.dog = dogs[position]
    }

    override fun getItemCount(): Int {
       return dogs.size
    }
}