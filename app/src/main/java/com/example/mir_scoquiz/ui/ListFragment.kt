package com.example.mir_scoquiz.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.databinding.FragmentListBinding
import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.networking.RetrofitInstance
import com.example.mir_scoquiz.networking.RetrofitInstance.apiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*

class ListFragment : Fragment() {

    lateinit var adapter: QuizListAdapter
    lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        getData()
        return binding.root
    }

    fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val questionList = apiInterface.getQuestions(10, "multiple", "easy")
            withContext(Dispatchers.Main) {
                binding.apply {
                    listView.layoutManager = LinearLayoutManager(requireContext())
                    adapter = QuizListAdapter(questionList.results).also {
                        listView.adapter = it
                    }
                }
            }
        }
    }
}
