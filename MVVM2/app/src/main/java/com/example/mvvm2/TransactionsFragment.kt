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

    private var transactionsDAO : TransactionsDAO?=null

    private var scope : CoroutineScope= CoroutineScope(SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            requireContext(),
            TransactionsDatabase::class.java,
            "TransactionsDatabase"
        ).build()

        transactionsDAO=db.transactionsDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTransactionsBinding.inflate(inflater, container, false)


        binding.fab.setOnClickListener {
            scope.launch {
                transactionsDAO?.insertTransaction(Transactions(null,24.5,
                    "24/01/21", "Test Transaction"))
            }
            Toast.makeText(requireContext(),"Record Added Successfully",Toast.LENGTH_SHORT).show()
        }

        binding.buttonShowRecords.setOnClickListener {
            val myTransactions= transactionsDAO?.getAllTransactions()

            scope.launch {

                myTransactions!!.collect {
                    it.forEach {
                        Log.d("hamza",it.TransactionID.toString())
                        Log.d("hamza",it.transactionAmount.toString())
                        Log.d("hamza",it.transactionComments.toString())
                    }
                }


            }

        }

        return binding.root
    }
}