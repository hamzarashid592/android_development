package com.example.firstkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.firstkotlin.Account
import com.example.firstkotlin.DBHelper
import com.example.firstkotlin.R
import com.example.firstkotlin.accountsAdapter
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    private var accountList = ArrayList<Account>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

//        Fetching data from the database
        val dbHelper = DBHelper(this,null)

//         Putting some records in the db
        Log.d("hamza", "putting some records")
//        dbHelper.addAccountRecord(Account(200.0,"Savings",null,20))
//        dbHelper.addAccountRecord(Account(200.0,"luxury",null,20))


        Log.d("hamza", "getting the records")
        accountList=dbHelper.getAccountRecord()


//        Initializing the grid layout manager and populating the recycler view
        var layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = accountsAdapter(this, accountList)


    }

}