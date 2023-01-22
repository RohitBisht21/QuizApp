package com.example.mir_scoquiz.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.models.Result

class QuizListAdapter(val context: ListFragment, val userList: List<Result>): RecyclerView.Adapter<QuizListAdapter.QuizViewHolder>() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
      val itemView=LayoutInflater.from(parent.context).inflate(R.layout.single_list_item,parent,false)
        return QuizViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        var currentItem=userList[position]
        holder.category.text= currentItem.toString()
        holder.type.text= currentItem.toString()
        holder.difficulty.text= currentItem.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val category:TextView=itemView.findViewById(R.id.list_title)
        val type:TextView=itemView.findViewById(R.id.list_description)
        val difficulty:TextView=itemView.findViewById(R.id.list_difficulty)
    }
}


