package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_STRING_ANSWERS = "answers"
private const val ARG_INT_CORRECT = "correct"

/**
 * A simple [Fragment] subclass.
 * Use the [FourthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonA4 = view.findViewById<Button>(R.id.buttonA4)
        val buttonB4 = view.findViewById<Button>(R.id.buttonB4)

        buttonA4.setOnClickListener {
            answers = answers + "a"
            findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment(answers!!, correct!!))
        }

        buttonB4.setOnClickListener {
            answers = answers + "b"
            correct = correct?.plus(1)
            findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment(answers!!, correct!!))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FourthFragment.
         */
        @JvmStatic
        fun newInstance(answers: String) =
            FourthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct!!)
                }
            }
    }
}