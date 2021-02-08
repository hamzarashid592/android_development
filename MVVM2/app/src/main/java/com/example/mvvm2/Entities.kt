package com.example.mvvm2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TransactionsTable")
data class Transactions(

    @PrimaryKey(autoGenerate = true) val TransactionID: Int? = 0,
    val transactionAmount: Double = 0.0,
    val transactionDate: String = "",
    val transactionComments: String = ""
)