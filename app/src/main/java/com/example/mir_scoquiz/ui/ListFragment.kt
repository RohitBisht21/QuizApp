package com.example.mir_scoquiz.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.models.QuestionQueryResult
import com.example.mir_scoquiz.networking.RetrofitInstance
import retrofit2.*

class ListFragment : Fragment() {
    lateinit var listView: RecyclerView
    lateinit var adapter:QuizListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    companion object {
        const val BASE_URL = "https://opentdb.com/"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_list,container,false)
        listView=view.findViewById(R.id.list_view)
        listView.layoutManager= LinearLayoutManager(requireContext())
        adapter=QuizListAdapter(this@ListFragment, emptyList())
        listView.adapter=adapter
        getData()
        return view

    }

    fun getData()
    {

        RetrofitInstance.apiInterface.getQuestions(10,"multiple").enqueue(object :
            Callback<QuestionQueryResult?> {
            override fun onResponse(
                call: Call<QuestionQueryResult?>,
                response: Response<QuestionQueryResult?>
            ) {
                val result: QuestionQueryResult?= response.body()

                if(result!=null)
                {
                    Log.e("api",result.toString())
                    adapter.userList=result.results
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<QuestionQueryResult?>, t: Throwable) {
                Log.e("api","Error in Fetching List",t)
            }
        })
    }




}
