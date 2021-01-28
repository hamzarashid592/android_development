package com.example.mvvm1

import androidx.room.*

@Dao
interface TransactionsDAO{

    @Insert
    suspend fun insertTransaction(transaction: Transactions)

    @Update
    suspend fun updateTransaction(transaction: Transactions)

    @Delete
    suspend fun deleteTransaction(transaction: Transactions)

    @Query("Select * from transactions")
    suspend fun getTransactions() : ArrayList<Transactions>


}