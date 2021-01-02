package com.example.firstkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstkotlin.R
import com.example.firstkotlin.myAdapter
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var hobbies: Array<String> = resources.getStringArray(R.array.hobbies)

        var icons: Array<Int> = arrayOf(
            R.drawable.dancing,
            R.drawable.swimming
            ,
            R.drawable.writing,
            R.drawable.programming
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager

        var adp: myAdapter =
            myAdapter(this, hobbies, icons)
        recyclerView.adapter = adp

    }
}

