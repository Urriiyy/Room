package com.example.room1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.room1.databinding.FragmentDogListBinding

import com.example.room1.room.DbConnection
import com.example.room1.room.DogRepository

class DogListFragment : Fragment() {

    private lateinit var binding: FragmentDogListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "db").build()
        var repository = DogRepository(db)
        var adapter = DogListAdapter()

        repository.dogs.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }

        binding.dogListRecyclerView.adapter = adapter


        binding.floatingActionButton.setOnClickListener {

//            val navHost = Navigation.findNavController(this, R.id.nav_host_fragment)
//            navHost.navigate(R.id.action_userListFragment_to_userCreatFragment)
            Navigation.findNavController(it).navigate(R.id.action_dogListFragment_to_dogCreatFragment)
        }
    }


}