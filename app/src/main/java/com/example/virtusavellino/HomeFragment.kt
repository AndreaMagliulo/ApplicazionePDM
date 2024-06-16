package com.example.virtusavellino

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view.findViewById(R.id.viewPager)

        val images = listOf(
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto3
        )
        val adapter = ImagePagerAdapter(images)
        viewPager.adapter = adapter

        return view
    }
}
