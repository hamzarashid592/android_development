package com.example.mvvm2

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.example.mvvm2.databinding.FragmentTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransactionsFragment : Fragment() {

    //    Instantiating the view model.
    private val viewModel: TransactionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTransactionsBinding.inflate(inflater, container, false)


        binding.fab.setOnClickListener {
//            Calling the view model insert method.
            viewModel.insertTransaction(
                Transactions(null,35.21,
            "24/01/2021","Inserting from view model"))
        }

        binding.buttonShowRecords.setOnClickListener {
            viewModel.getAllTransactions()!!.forEach {
                Log.d("hamza","")
            }

        }

        return binding.root
    }
}