package com.example.mir_scoquiz.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.databinding.FragmentSplashBinding
import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.networking.RetrofitInstance
import com.google.gson.Gson
import retrofit2.*

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var listView: RecyclerView
    private lateinit var binding: FragmentSplashBinding
    private  lateinit var adapter:QuizListAdapter
    private lateinit var questionArrayList:ArrayList<QuestionQueryResult>

    lateinit var imageId:Array<Int>
    lateinit var category:Array<String>
    lateinit var type:Array<String>
    lateinit var difficulty:Array<String>

    companion object {
        const val BASE_URL = "https://opentdb.com/"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
        getData()
    }

private fun getData()
{
    RetrofitInstance.apiInterface.getQuestions().enqueue(object : Callback<QuestionQueryResult?> {
        override fun onResponse(
            call: Call<QuestionQueryResult?>,
            response: Response<QuestionQueryResult?>
        ) {
            TODO("Not yet implemented")
        }

        override fun onFailure(call: Call<QuestionQueryResult?>, t: Throwable) {
       //  Toast.makeText(this@ListFragment,"${t.localizedMessage}",Toast.LENGTH_SHORT).show()
        }
    })
}
}
