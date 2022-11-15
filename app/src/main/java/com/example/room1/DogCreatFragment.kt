package com.example.room1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.room1.databinding.FragmentDogCreatBinding

import com.example.room1.room.DbConnection
import com.example.room1.room.Dog
import com.example.room1.room.DogRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DogCreatFragment : Fragment() {

    private lateinit var binding: FragmentDogCreatBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogCreatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db" ).build()
        var repository = DogRepository(db)


       binding.button.setOnClickListener {
           var name = binding.editTextTextPersonName.text.toString()
           var breed = binding.editTextTextPassword.text.toString()



           GlobalScope.launch {
               repository.incert(Dog(name, breed))
           }

           Navigation.findNavController(it)
               .navigate(R.id.action_dogCreatFragment_to_dogListFragment)


       }
    }


}