package com.example.mir_scoquiz.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.databinding.SingleListItemBinding
import com.example.mir_scoquiz.models.Result

class QuizListAdapter(
    var userList: List<Result>
) : RecyclerView.Adapter<QuizListAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val binding =
            SingleListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.apply {
            listTitle.text = currentItem.category
            listDescription.text = currentItem.type
            listDifficulty.text = currentItem.difficulty
        }
    }

    override fun getItemCount(): Int = userList.size
    class QuizViewHolder(val binding: SingleListItemBinding) : RecyclerView.ViewHolder(binding.root)
}


