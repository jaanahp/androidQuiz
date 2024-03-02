package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

private const val ARG_STRING_ANSWERS = "answers"
private const val ARG_INT_CORRECT = "correct"

class FourthFragment : Fragment() {
    private var answers: String? = null
    private var correct: Int? = null

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
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA4 = view.findViewById<Button>(R.id.buttonA4)
        val buttonB4 = view.findViewById<Button>(R.id.buttonB4)
        val fragm = FifthFragment.newInstance(answers!!, correct!!)

        buttonA4.setOnClickListener {
            answers = answers + "a"
            findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment(answers!!, fragm.checkAnswers(answers!!)))
        }

        buttonB4.setOnClickListener {
            answers = answers + "b"
            findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment(answers!!, fragm.checkAnswers(answers!!)))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(answers: String, correct: Int) =
            FourthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct)
                }
            }
    }
}