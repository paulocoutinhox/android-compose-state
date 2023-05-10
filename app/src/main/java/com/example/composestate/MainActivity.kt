package com.example.composestate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val myFragment = SampleFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add fragment to activity
        supportFragmentManager.beginTransaction()
            .add(R.id.my_fragment_container, myFragment)
            .commit()
    }
}
