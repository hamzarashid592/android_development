package com.example.mvvm2

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionsDAO{

    @Insert
    suspend fun insertTransaction(transaction: Transactions)

    @Delete
    suspend fun deleteTransaction(transaction: Transactions)

    @Update
    suspend fun updateTransaction(transaction: Transactions)

    @Query("Select * from TransactionsTable")
    fun getAllTransactions() : Flow<List<Transactions>>
}