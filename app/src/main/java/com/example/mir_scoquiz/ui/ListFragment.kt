package com.example.mir_scoquiz.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.databinding.FragmentSplashBinding
import com.example.mir_scoquiz.networking.OpenDBApi
import retrofit2.Retrofit
import retrofit2.create


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var listView: RecyclerView
    private lateinit var binding: FragmentSplashBinding
    companion object {
        const val BASE_URL = "https://opentdb.com/"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)

        return binding.root
    }

}
