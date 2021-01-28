package com.example.mvvm1

import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped

class TransactionsViewModel @ViewModelScoped constructor(
    val transactionsDAO: TransactionsDAO
) : ViewModel() {
}