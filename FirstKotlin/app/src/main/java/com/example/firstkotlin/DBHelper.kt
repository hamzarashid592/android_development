package com.example.firstkotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import java.util.concurrent.CopyOnWriteArrayList
import java.util.prefs.PreferencesFactory
import kotlin.coroutines.coroutineContext

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(
    context, DB_NAME, factory,
    DB_VERSION
) {
    val context = context

    private companion object {
        val DB_NAME = "WalletDB"
        val DB_VERSION = 5

        val ACCOUNT_TABLE = "Account"
        val COL_ACCOUNT_ID = "AccountID"
        val COL_ACCOUNT_NAME = "AccountName"
        val COL_ACCOUNT_BALANCE = "AccountBalance"
        val COL_ACCOUNT_NUM_RECORDS = "AccountNumRecords"

        val TRANSACTION_TABLE = "Transactions"
        val COL_TRANSACTION_ID = "TransactionID"
        val COL_TRANSACTION_DATE = "TransactionDate"
        val COL_TRANSACTION_TIME = "TransactionTime"
        val COL_TRANSACTION_AMOUNT = "TransactionAmount"
        val COL_TRANSACTION_TYPE = "TransactionType"
        val COL_TRANSACTION_COMMENTS = "TransactionComments"

        val TRIGGER_ALTER_BALANCE="alter_balance"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {

//            Creating the accounts table
            createTable(
                tableName = ACCOUNT_TABLE, db = db
            )

//            Creating the transaction table
            createTable(
                tableName = TRANSACTION_TABLE, db = db
            )

//            Creating the alter_balance trigger that will be fired on the account table
//            whenever a transaction would be added.
            createTrigger(TRIGGER_ALTER_BALANCE,db)


        }
        Log.d("hamza", "Created the database")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

//        Dropping thr account table
        db?.let {
            dropTable(tableName = ACCOUNT_TABLE, db = db)
        }

//        Dropping the transaction table
        db?.let {
            dropTable(tableName = TRANSACTION_TABLE, db = db)
        }

//        Deleting the trigger
        db?.let {
            dropTrigger(triggerName = TRIGGER_ALTER_BALANCE,db = db)
        }


        onCreate(db)
        Log.d("hamza", "Updated the database to version $DB_VERSION")
    }

    override fun onOpen(db: SQLiteDatabase?) {

//            Enabling foreign key constraints in the database.
        db?.let {
            if (!db.isReadOnly)
                db.setForeignKeyConstraintsEnabled(true)
        }


    }

    //    Create table function that takes the table name as the parameter. Here the db object should be passed as a parameter
    //    i.e. db=this.writableDatabase should be avoided in the onCreate and onUpdate function.
    private fun createTable(tableName: String, db: SQLiteDatabase) {

//    Executing the query  based on the given table
        if (tableName == ACCOUNT_TABLE)
            db.execSQL(
                "Create table $tableName " +
                        "($COL_ACCOUNT_ID integer primary key autoincrement," +
                        "$COL_ACCOUNT_NAME varchar(255)," +
                        "$COL_ACCOUNT_BALANCE Double," +
                        "$COL_ACCOUNT_NUM_RECORDS integer);"
            )
        else if (tableName == TRANSACTION_TABLE)
            db.execSQL(
                "create table $tableName ($COL_TRANSACTION_ID Integer primary key autoincrement not null, \n" +
                        "$COL_TRANSACTION_DATE Text, \n" +
                        "$COL_TRANSACTION_TIME Text, \n" +
                        "$COL_TRANSACTION_AMOUNT double, \n" +
                        "$COL_TRANSACTION_TYPE Text check (transactionType=\"Income\" or transactionType=\"Expense\"),\n" +
                        "$COL_TRANSACTION_COMMENTS Text,\n" +
                        "$COL_ACCOUNT_ID integer not null,\n" +
                        "foreign key ($COL_ACCOUNT_ID) references $ACCOUNT_TABLE($COL_ACCOUNT_ID) on delete cascade);"
            )
    }

    private fun dropTable(tableName: String, db: SQLiteDatabase) {

//        Executing the query
        db.execSQL("Drop table if exists $tableName;")
    }

    private fun createTrigger(triggerName: String, db: SQLiteDatabase) {
        db.execSQL(
            "create trigger $triggerName after insert on $TRANSACTION_TABLE\n" +
                    "begin\n" +
                    "update $ACCOUNT_TABLE set $COL_ACCOUNT_BALANCE=case when new.$COL_TRANSACTION_TYPE=\"Expense\" then $COL_ACCOUNT_BALANCE-new.$COL_TRANSACTION_AMOUNT \n" +
                    "else $COL_ACCOUNT_BALANCE+new.$COL_TRANSACTION_AMOUNT end, $COL_ACCOUNT_NUM_RECORDS=$COL_ACCOUNT_NUM_RECORDS+1 where $COL_ACCOUNT_ID=new.$COL_ACCOUNT_ID;\n" +
                    "end;"
        )
    }

    private fun dropTrigger(triggerName: String, db: SQLiteDatabase) {

//        Executing the query
        db.execSQL("Drop trigger if exists $triggerName")
    }


    fun getAccountRecord(): ArrayList<Account> {

        val accountList = ArrayList<Account>()

        val db: SQLiteDatabase = readableDatabase

        if (db != null) {
            val cursor: Cursor = db.rawQuery("Select * from $ACCOUNT_TABLE", null)

//            If no data in the table
            if (cursor.count == 0)
                Toast.makeText(context, "No accounts created", Toast.LENGTH_SHORT).show()

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

    fun addAccountRecord(accountRecord: Account) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ACCOUNT_NAME, accountRecord.accountName)
        contentValues.put(COL_ACCOUNT_BALANCE, accountRecord.accountBalance)
        contentValues.put(COL_ACCOUNT_NUM_RECORDS, accountRecord.accountNumRecords)
        db.insert(ACCOUNT_TABLE, null, contentValues)
        db.close()
        Toast.makeText(context,"Account ${accountRecord.accountName} added successfully",Toast.LENGTH_SHORT).show()
    }

    fun addTransactionRecord(transactionRecord: Transaction) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_TRANSACTION_AMOUNT, transactionRecord.transactionAmount)
        contentValues.put(COL_TRANSACTION_COMMENTS, transactionRecord.transactionComments)
        contentValues.put(COL_TRANSACTION_DATE, transactionRecord.transactionDate)
        contentValues.put(COL_TRANSACTION_TIME, transactionRecord.transactionTime)
        contentValues.put(COL_TRANSACTION_TYPE, transactionRecord.transactionType)
        contentValues.put(COL_ACCOUNT_ID, transactionRecord.accountID)
        db.insert(TRANSACTION_TABLE, null, contentValues)
        db.close()
        Toast.makeText(context,"Transaction added successfully",Toast.LENGTH_SHORT).show()
    }

    fun getTransactionRecord(): ArrayList<Transaction> {

        val transactionList = ArrayList<Transaction>()

        val db: SQLiteDatabase = readableDatabase

        if (db != null) {
            val cursor: Cursor = db.rawQuery("Select * from $TRANSACTION_TABLE", null)

//            If no data in the table
            if (cursor.count == 0)
                Toast.makeText(context, "No records found!", Toast.LENGTH_SHORT).show()

            while (cursor.moveToNext()) {
                val transaction =Transaction()

                transaction.accountID=cursor.getInt(cursor.getColumnIndex(COL_ACCOUNT_ID))
                transaction.transactionAmount=cursor.getDouble(cursor.getColumnIndex(
                    COL_TRANSACTION_AMOUNT))
                transaction.transactionComments=cursor.getString(cursor.getColumnIndex(
                    COL_TRANSACTION_COMMENTS))
                transaction.transactionDate=cursor.getString(cursor.getColumnIndex(
                    COL_TRANSACTION_DATE))
                transaction.transactionID=cursor.getInt(cursor.getColumnIndex(COL_TRANSACTION_ID))
                transaction.transactionTime=cursor.getString(cursor.getColumnIndex(
                    COL_TRANSACTION_TIME))
                transaction.transactionType=cursor.getString(cursor.getColumnIndex(
                    COL_TRANSACTION_TYPE))

                transactionList.add(transaction)
            }
            cursor.close()
        }

        db.close()
        return transactionList
    }


}