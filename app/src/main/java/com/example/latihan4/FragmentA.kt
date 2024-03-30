package com.example.latihan4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.widget.Button

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dapatkan NavController
        val navController = findNavController()

        // Tambahkan onClickListener ke button atau elemen yang akan menavigasi ke FragmentB
        view.findViewById<Button>(R.id.button_to_fragment_b).setOnClickListener {
            // Navigasi dari FragmentA ke FragmentB
            navController.navigate(R.id.action_fragmentA_to_fragmentB)
        }
    }
}
