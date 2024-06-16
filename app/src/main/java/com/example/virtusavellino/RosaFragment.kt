package com.example.virtusavellino

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class RosaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rosa, container, false)

        val player1Image = view.findViewById<ImageView>(R.id.prova)
        player1Image.setOnClickListener {
            val intent = Intent(requireContext(), GiocatoreActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
