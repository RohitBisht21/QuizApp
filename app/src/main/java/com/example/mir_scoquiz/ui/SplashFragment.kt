package com.example.mir_scoquiz.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import android.os.Handler
import kotlinx.coroutines.tasks.await

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            if (firebaseAuth.currentUser == null) {
                runCatching {
                    firebaseAuth.signInAnonymously().await()
                }.onSuccess {
                    navigateToListScreen()
                }.onFailure {
                    Log.e(TAG, "GSign In Failure", it)
                }
            } else {
                navigateToListScreen()
            }
        }
    }

    private fun navigateToListScreen() {
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashFragment_to_listFragment)
        }
    }
}