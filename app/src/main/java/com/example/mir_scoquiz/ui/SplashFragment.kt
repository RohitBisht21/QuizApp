package com.example.mir_scoquiz.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mir_scoquiz.R
import com.example.mir_scoquiz.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment(R.layout.fragment_splash) {
    // TODO: Rename and change types of parameter
    companion object {
        private final const val STARTLOG: String = "Start log"
    }

    private lateinit var binding: FragmentSplashBinding


    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance() }
    private val navController: NavController by lazy {
        Navigation.findNavController(binding.root)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater)
        val currentUser = firebaseAuth.getCurrentUser()
        if (currentUser == null) {
            firebaseAuth.signInAnonymously()
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        navigateToListScreen()
                    } else {
                        Log.d(TAG, "signInAnonymously:failed" + task.exception)
                    }
                }
        } else {
            navigateToListScreen()
        }
        return binding.root
    }
    fun navigateToListScreen() {
        lifecycleScope.launch {
            delay(2000)
            navController.navigate(R.id.action_splashFragment2_to_listFragment)
        }
    }


}