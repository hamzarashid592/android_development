package com.example.mvvm2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = arrayOf(Transactions::class), version = 1)
abstract class TransactionsDatabase : RoomDatabase(){

    abstract fun transactionsDao(): TransactionsDAO

}

class myCallback @Inject constructor(
    private val myDB : Provider<TransactionsDatabase>,
    private val scope: CoroutineScope
) : RoomDatabase.Callback(){
    private var transactionsDAO : TransactionsDAO?=null


    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)


        transactionsDAO=myDB.get().transactionsDao()

        scope.launch {
            transactionsDAO!!.insertTransaction(
                Transactions(null,200.35,
                    "24/01/2021","Inserting from the onCreate function")
            )

        }

    }
}