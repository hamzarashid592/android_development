package com.example.firstkotlin.activities

import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.firstkotlin.*
import kotlinx.android.synthetic.main.activity_main4.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity4 : AppCompatActivity() {

    private var accountList = ArrayList<Account>()
    private var transactionList=ArrayList<Transaction>()
    private var accountID2AccountName= HashMap<Int,String>()

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

//        Getting the account data
        accountList = dbHelper.getAccountRecord()

//        Getting the transaction data.
        transactionList=dbHelper.getTransactionRecord()

//        Getting a map of account ids and account names.
        accountID2AccountName=dbHelper.getAccountNames()


//        Initializing the grid layout manager for the accounts recycler view and populating it
        var layoutManager1 = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        accounts_recycler_view.layoutManager = layoutManager1
        accounts_recycler_view.adapter = accountsAdapter(this, accountList)

//        Initializing the grid layout manager for the accounts recycler view and populating it
        var layoutManager2 = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        transactions_recycler_view.layoutManager=layoutManager2
        transactions_recycler_view.adapter=transactionsAdapter(this,transactionList,accountID2AccountName)


    }

}