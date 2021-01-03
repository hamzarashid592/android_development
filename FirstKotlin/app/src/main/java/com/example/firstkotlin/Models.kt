package com.example.firstkotlin

data class Account (
    var accountBalance: Double = 0.0,
    var accountName: String = "",
    var accountID : Int? = 0,
    var accountNumRecords : Int = 0
)