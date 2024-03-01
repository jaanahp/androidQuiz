package com.example.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.databinding.FragmentSecondBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_STRING_ANSWERS = "answers"
private const val ARG_INT_CORRECT = "correct"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private var answers: String? = null
    private var correct: Int? = null

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        buttonA2.setOnClickListener {
            answers = answers + "a"
            //findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(answers!!, correct!!))
        }

        buttonB2.setOnClickListener {
            answers = answers + "b"
            correct = correct?.plus(1)
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(answers!!, correct!!))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * param answers string to receive from another fragment
         * @return A new instance of fragment SecondFragment.
         */
        @JvmStatic
        fun newInstance(answers: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STRING_ANSWERS, answers)
                    putInt(ARG_INT_CORRECT, correct!!)
                }
            }
    }
}