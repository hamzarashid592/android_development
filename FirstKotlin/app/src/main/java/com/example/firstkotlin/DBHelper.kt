package com.example.firstkotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import java.util.prefs.PreferencesFactory
import kotlin.coroutines.coroutineContext

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(
    context, DB_NAME, factory,
    DB_VERSION
) {
    val context=context

    private companion object {
        val DB_NAME = "WalletDB"
        val DB_VERSION = 4
        val ACCOUNT_TABLE = "Account"
        val COL_ACCOUNT_ID = "AccountID"
        val COL_ACCOUNT_NAME = "AccountName"
        val COL_ACCOUNT_BALANCE = "AccountBalance"
        val COL_ACCOUNT_NUM_RECORDS = "AccountNumRecords"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
//            Creating the accounts table
            createTable(
                tableName = ACCOUNT_TABLE, db = db,
                columns = *arrayOf(
                    COL_ACCOUNT_ID, COL_ACCOUNT_NAME, COL_ACCOUNT_BALANCE,
                    COL_ACCOUNT_NUM_RECORDS
                )
            )
        }
        Log.d("hamza", "Created the database")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            dropTable("$ACCOUNT_TABLE", db = db)
        }
        onCreate(db)
        Log.d("hamza", "Updated the database to version $DB_VERSION")
    }


    //    Create table function that takes the table name as the parameter. Here the db object should be passed as a parameter
    //    i.e. db=this.writableDatabase should be avoided in the onCreate and onUpdate function.
    private fun createTable(tableName: String, db: SQLiteDatabase, vararg columns: String) {
//    Executing the query
        db.execSQL(
            "Create table $tableName " +
                    "(${columns[0]} integer primary key autoincrement," +
                    "${columns[1]} varchar(255)," +
                    "${columns[2]} Double," +
                    "${columns[3]} double)"
        )
    }

    private fun dropTable(tableName: String, db: SQLiteDatabase) {

//        Executing the query
        db.execSQL("Drop table if exists $tableName")
    }


    fun getAccountRecord() : ArrayList<Account> {

        val accountList = ArrayList<Account>()

        val db: SQLiteDatabase = readableDatabase

        if (db!=null) {
            val cursor: Cursor = db.rawQuery("Select * from $ACCOUNT_TABLE", null)

//            If no data in the table
            if (cursor.count==0)
                Toast.makeText(context, "No records found",Toast.LENGTH_SHORT).show()

            while (cursor.moveToNext()) {
                val account = Account()
                account.accountID = cursor.getInt(cursor.getColumnIndex(COL_ACCOUNT_ID))
                account.accountName = cursor.getString(cursor.getColumnIndex(COL_ACCOUNT_NAME))
                account.accountBalance =
                    cursor.getDouble(cursor.getColumnIndex(COL_ACCOUNT_BALANCE))
                account.accountNumRecords =
                    cursor.getInt(cursor.getColumnIndex(COL_ACCOUNT_NUM_RECORDS))

                accountList.add(account)
            }
            cursor.close()
        }

        db.close()
        return accountList
    }

    fun addAccountRecord(accountRecord : Account){
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(COL_ACCOUNT_NAME,accountRecord.accountName)
        contentValues.put(COL_ACCOUNT_BALANCE,accountRecord.accountBalance)
        contentValues.put(COL_ACCOUNT_NUM_RECORDS,accountRecord.accountNumRecords)
        db.insert(ACCOUNT_TABLE,null,contentValues)
        db.close()
    }


}