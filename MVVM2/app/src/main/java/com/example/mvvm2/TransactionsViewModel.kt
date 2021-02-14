package com.example.mvvm2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TransactionsViewModel(myApp: myApp) : AndroidViewModel(myApp) {

    var transactionsDAO: TransactionsDAO? = null
    private var db: TransactionsDatabase? = null
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

    init {
        db = Room.databaseBuilder(myApp, TransactionsDatabase::class.java, "TransactionsDB")
            .build()
        transactionsDAO = db!!.transactionsDao()
    }

    fun insertTransaction(input_transaction: Transactions) {
        scope.launch {
            transactionsDAO!!.insertTransaction(input_transaction)
        }
    }

    fun getAllTransactions(): List<Transactions>? {
        var myTransactions: List<Transactions>? = null

        scope.launch {
            transactionsDAO!!.getAllTransactions().collect { it ->
                myTransactions = it
            }
        }
        return myTransactions
    }


}