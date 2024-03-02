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
class ThirdFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA3 = view.findViewById<Button>(R.id.buttonA3)
        val buttonB3 = view.findViewById<Button>(R.id.buttonB3)
        val fragm = FifthFragment.newInstance(answers!!, correct!!)

        buttonA3.setOnClickListener {
            answers = answers + "a"
            correct = fragm.checkAnswers(answers!!)

            if (correct!! == 0) {
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFifthFragment(answers!!, correct!!))
            } else {
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFourthFragment(answers!!, correct!!))
            }
        }

        buttonB3.setOnClickListener {
            answers = answers + "b"
            correct = fragm.checkAnswers(answers!!)

            if (correct!! == 0) {
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFifthFragment(answers!!, correct!!))
            } else {
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFourthFragment(answers!!, correct!!))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(answers: String, correct: Int) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct)
                }
            }
    }
}