package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

private const val ARG_STRING_ANSWERS = "answers"
private const val ARG_INT_CORRECT = "correct"

class FifthFragment : Fragment() {
    private var answers: String? = null
    private var correct: Int? = null
    private lateinit var textViewAnswer: TextView

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
        return inflater.inflate(R.layout.fragment_fifth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA5 = view.findViewById<Button>(R.id.buttonA5)
        val buttonB5 = view.findViewById<Button>(R.id.buttonB5)
        val buttonToFirst = view.findViewById<Button>(R.id.buttonToFirst)
        val textViewFifth = view.findViewById<TextView>(R.id.textViewFifth)
        textViewAnswer = view.findViewById(R.id.textViewAnswer)

        if (correct!! <= 1) {
            textViewAnswer.text = "Tulos: " + correct + "/5"
            textViewFifth.text = "Peli loppui!"
            buttonA5.isEnabled = false
            buttonB5.isEnabled = false
        }

        else {

            buttonA5.setOnClickListener {
                answers = answers + "a"
                correct = checkAnswers(answers!!)

                if (answers!!.length >= 5) {
                    buttonA5.isEnabled = false
                    buttonB5.isEnabled = false
                    textViewFifth.text = "Peli loppui!"
                    textViewAnswer.text = "Tulos: " + correct + "/5"
                }
            }

            buttonB5.setOnClickListener {
                answers = answers + "b"
                correct = checkAnswers(answers!!)

                if (answers!!.length >= 5) {
                    buttonA5.isEnabled = false
                    buttonB5.isEnabled = false
                    textViewFifth.text = "Peli loppui!"
                    textViewAnswer.text = "Tulos: " + correct + "/5"
                }
            }
        }

        buttonToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_fifthFragment_to_FirstFragment)
        }
    }

    fun checkAnswers(answers: String): Int {
        val correctAnswers = "bbaba".toCharArray()
        var correctAmount = 0
        var answerArray = answers.toCharArray()

        for (i in answerArray.indices) {
            if(answerArray[i] == correctAnswers[i]) {
                correctAmount ++
            }
        }

        return correctAmount
    }
    companion object {
        @JvmStatic
        fun newInstance(answers: String, correct: Int) =
            FifthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct)
                }
            }
    }
}