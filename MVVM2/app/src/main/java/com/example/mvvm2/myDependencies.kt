package com.example.mvvm2

import android.app.Application
import androidx.compose.ui.graphics.vector.RootGroupName
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object myDependencies {

    @Provides
    @Singleton
    fun instantiateDB(app: Application, callback : myCallback) : TransactionsDatabase{
        val db= Room.databaseBuilder(app,TransactionsDatabase::class.java,"TransactiosDB")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
        return db
    }

    @Provides
    fun instantiateDAO(transactionsDatabase: TransactionsDatabase) : TransactionsDAO{
        return transactionsDatabase.transactionsDao()
    }

    @Provides
    @Singleton
    fun getScope() : CoroutineScope{
        return CoroutineScope(SupervisorJob())
    }

}