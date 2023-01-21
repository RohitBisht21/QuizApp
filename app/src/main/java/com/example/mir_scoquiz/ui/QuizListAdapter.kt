package com.example.mir_scoquiz.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.models.Result
import com.google.android.material.imageview.ShapeableImageView

class QuizListAdapter(val context:Context,val userList:List<Result>): RecyclerView.Adapter<QuizListAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
      val itemView=LayoutInflater.from(parent.context).inflate(R.layout.single_list_item,parent,false)
        return QuizViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val currentItem=userList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.category.text=currentItem.category
        holder.type.text=currentItem.type
        holder.difficulty.text=currentItem.difficulty
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage:ShapeableImageView=itemView.findViewById(R.id.list_image)
        val category:TextView=itemView.findViewById(R.id.list_title)
        val type:TextView=itemView.findViewById(R.id.list_description)
        val difficulty:TextView=itemView.findViewById(R.id.list_difficulty)
    }
}