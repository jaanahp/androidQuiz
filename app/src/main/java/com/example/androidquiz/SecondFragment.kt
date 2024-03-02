package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.databinding.FragmentSecondBinding

private const val ARG_STRING_ANSWERS = "answers"
private const val ARG_INT_CORRECT = "correct"

class SecondFragment : Fragment() {
    private var answers: String? = null
    private var correct: Int? = null
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            answers = it.getString(ARG_STRING_ANSWERS)
            correct = it.getInt(ARG_INT_CORRECT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA2 = view.findViewById<Button>(R.id.buttonA2)
        val buttonB2 = view.findViewById<Button>(R.id.buttonB2)
        val fragm = FifthFragment.newInstance(answers!!, correct!!)

        buttonA2.setOnClickListener {
            answers = answers + "a"
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(answers!!, fragm.checkAnswers(answers!!)))
        }

        buttonB2.setOnClickListener {
            answers = answers + "b"
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(answers!!, fragm.checkAnswers(answers!!)))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(answers: String, correct: Int) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct)
                }
            }
    }
}