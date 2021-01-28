package com.example.mvvm1

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = arrayOf(Transactions::class),version = 1)
abstract class TransactionsDB() : RoomDatabase(){
    abstract fun transactionsDAO() : TransactionsDAO

    class TransactionCallback @Inject constructor(
        val transactionsDB: Provider<TransactionsDB>,
        @AppScope val scope : CoroutineScope
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao=transactionsDB.get().transactionsDAO()

            scope.launch {
                dao.insertTransaction(Transactions(transactionName = "Car Purchase"))
                dao.insertTransaction(Transactions(transactionName = "Watch Purchase"))
                dao.insertTransaction(Transactions(transactionName = "Groceries"))
                dao.insertTransaction(Transactions(transactionName = "Vendi"))
                dao.insertTransaction(Transactions(transactionName = "Token"))
                dao.insertTransaction(Transactions(transactionName = "Laddoo"))
            }


        }
    }
}