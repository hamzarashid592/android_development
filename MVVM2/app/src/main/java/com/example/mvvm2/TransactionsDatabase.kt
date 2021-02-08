package com.example.mvvm2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Transactions::class), version = 1)
abstract class TransactionsDatabase : RoomDatabase(){

    abstract fun transactionsDao(): TransactionsDAO
}