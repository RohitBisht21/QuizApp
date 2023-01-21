package com.example.mir_scoquiz.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.models.Result

class QuizListAdapter(val context:Context,val userList:List<Result>): RecyclerView.Adapter<QuizListAdapter.QuizViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}