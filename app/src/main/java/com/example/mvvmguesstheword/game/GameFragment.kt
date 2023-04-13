package com.example.mvvmguesstheword.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmguesstheword.databinding.GameFragmentBinding

class GameFragment : Fragment() {
    private lateinit var binding: GameFragmentBinding
    private val viewModel: GameViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GameFragmentBinding.inflate(inflater, container, false)

        binding.skipButton.setOnClickListener {
            viewModel.onSkip()

        }

        binding.endGameButton.setOnClickListener {
            val score = binding.scoreText.text.toString().toInt()
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment().setScore(score))

        }

        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
        }

        viewModel.word.observe(viewLifecycleOwner) { word ->
            binding.wordText.text = word

        }

        viewModel.score.observe(viewLifecycleOwner) { score ->
            binding.scoreText.text = score.toString()

        }
        return binding.root
    }
}