package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    var answers: String = ""
    var correct: Int = 0

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA1 = view.findViewById<Button>(R.id.buttonA1)
        val buttonB1 = view.findViewById<Button>(R.id.buttonB1)
        val fragm = FifthFragment.newInstance(answers!!, correct!!)

        buttonA1.setOnClickListener {
            answers = "a"
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(answers, fragm.checkAnswers(answers)))
        }

        buttonB1.setOnClickListener {
            answers = "b"
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(answers, fragm.checkAnswers(answers)))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}