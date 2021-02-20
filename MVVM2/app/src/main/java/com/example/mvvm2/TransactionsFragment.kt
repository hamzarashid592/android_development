package com.example.mvvm2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.mvvm2.databinding.FragmentTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint

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
            Toast.makeText(context,"Transaction inserted successfully",Toast.LENGTH_SHORT).show()
        }

        binding.buttonShowRecords.setOnClickListener {

            viewModel.allTransactions?.observe(viewLifecycleOwner){
                it.forEach {
                    Log.d("hamza","${it.TransactionID}\t${it.transactionAmount}\t${it.transactionComments}")
                }
            }


        }

        return binding.root
    }
}