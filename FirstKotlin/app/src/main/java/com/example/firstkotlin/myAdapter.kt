package com.example.firstkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class myAdapter(
    private val context: Context,
    private val items: Array<String>,
    private val icons: Array<Int>
) :
    RecyclerView.Adapter<myAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pos: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, "You have selected ${items[pos]}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.itemViewImageView.setOnClickListener {
                val intent: Intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Share ${items[pos]}")
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Open With"))
            }
        }

        fun setText(text: String): Unit {
            itemView.itemViewTextView.setText(text)
        }

        fun setImage(image: Int): Unit {
            itemView.itemViewImageView.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        val viewHolder: myViewHolder = myViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.setText(items[position])
        holder.setImage(icons[position])
        holder.pos = position

    }
}