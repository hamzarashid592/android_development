package com.example.firstkotlin.activities

import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.firstkotlin.*
import kotlinx.android.synthetic.main.activity_main4.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity4 : AppCompatActivity() {

    private var accountList = ArrayList<Account>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

//        Fetching data from the database
        val dbHelper = DBHelper(this, null)

//         Putting some records in the account table
//        dbHelper.addAccountRecord(Account(200.0,"luxury",null,0))


        val date = LocalDateTime.now()
        val formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
        val formattedTime = date.format(DateTimeFormatter.ofPattern("hh:mm:ss a")).toString()

//        Putting some transactions.
//        dbHelper.addTransactionRecord(
//            Transaction(
//                null, formattedDate, formattedTime, 30.0, "Income"
//                , 4, "First transaction"
//            )
//        )
//        dbHelper.addTransactionRecord(
//            Transaction(
//                null, formattedDate, formattedTime, 30.0, "Income"
//                , 4, "Second transaction"
//            )
//        )
//        dbHelper.addTransactionRecord(
//            Transaction(
//                null, formattedDate, formattedTime, 50.0, "Income"
//                , 5, "First transaction"
//            )
//        )



        accountList = dbHelper.getAccountRecord()
        Log.d("hamza",accountList[3].accountNumRecords.toString())
        Log.d("hamza",accountList[4].accountNumRecords.toString())
        Log.d("hamza",accountList[5].accountNumRecords.toString())


//        Initializing the grid layout manager and populating the recycler view
        var layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = accountsAdapter(this, accountList)


    }

}