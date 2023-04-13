package com.example.mvvmguesstheword.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvvmguesstheword.databinding.ScoreFragmentBinding

class ScoreFragment :Fragment() {
    private lateinit var binding: ScoreFragmentBinding
    private val args:ScoreFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScoreFragmentBinding.inflate(inflater,container,false)
        binding.scoreText.text = args.score.toString()
        binding.playAgainButton.visibility = View.VISIBLE
        binding.playAgainButton.setOnClickListener {
            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToWelcomeFragment())
        }
        return binding.root
    }
}