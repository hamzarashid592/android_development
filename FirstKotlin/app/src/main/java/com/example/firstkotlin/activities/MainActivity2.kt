package com.example.firstkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlin.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //main activity 2
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val someText : String?= intent.extras?.getString("text2")
        text.setText(someText)
    }
}