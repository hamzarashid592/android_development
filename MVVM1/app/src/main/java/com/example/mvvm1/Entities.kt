package com.example.mvvm1

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Transactions (
    @PrimaryKey(autoGenerate = true) var transactionID : Int = 0,
    var transactionName : String,
    var transactionAmount : Double = 0.0,
    var transactionComments : String = "",
    var transactionDate: Date = Date(10012021)

)