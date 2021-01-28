package com.example.mvvm1

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideDB(application: Application, callback: TransactionsDB.TransactionCallback): TransactionsDB{
        return Room.databaseBuilder(application,TransactionsDB::class.java,"TransactionsDB")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideDao(db : TransactionsDB): TransactionsDAO {
        return db.transactionsDAO()
    }

    @Provides
    @AppScope
    @Singleton
    fun provideScope() : CoroutineScope{
        return CoroutineScope(SupervisorJob())
    }

}
@Qualifier
annotation class AppScope