package com.example.firstkotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Explicit intent
        button1.setOnClickListener {
            Toast.makeText(applicationContext,"Button was clicked",Toast.LENGTH_SHORT).show()
            val intnt= Intent(applicationContext,
                MainActivity2::class.java)
            intnt.putExtra("text1","Message from main activity")
            startActivity(intnt)
        }

//        Implicit intent
        button2.setOnClickListener {
            val intent : Intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Text from the main activity. Implicit intent")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Open With"))
        }

        button3.setOnClickListener {
            val intnt= Intent(applicationContext,
                MainActivity3::class.java)
            startActivity(intnt)
        }


    }
}