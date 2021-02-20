package com.example.mvvm2


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TransactionsViewModel @ViewModelInject constructor(
    private val transactionsDAO: TransactionsDAO,
    private val scope: CoroutineScope
) : ViewModel() {


    var allTransactions: LiveData<List<Transactions>>?=transactionsDAO.getAllTransactions().asLiveData()



    fun insertTransaction(input_transaction: Transactions) {
        scope.launch {
            transactionsDAO.insertTransaction(input_transaction)
        }
    }




}