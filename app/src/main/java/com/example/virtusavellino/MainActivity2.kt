package com.example.virtusavellino

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.calendario -> {
                    replaceFragment(CalendarioFragment())
                    true
                }
                R.id.rosa -> {
                    replaceFragment(RosaFragment())
                    true
                }
                R.id.bottom_home -> {
                    val intent = Intent(this@MainActivity2, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.classifica -> {
                    replaceFragment(ClassificaFragment())
                    true
                }
                R.id.capocannoniere -> {
                    replaceFragment(CapocannoniereFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(RosaFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}
