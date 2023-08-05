package com.example.inthebeningin.activity.ex6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.FragmentSimpleBinding


class SimpleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSimpleBinding.inflate(inflater,container,false)
        binding.radioGroup.setOnCheckedChangeListener { _, checkID ->
            when (checkID) {
                binding.radioButtonNo.id -> binding.textFrag.setText(R.string.no_message)
                binding.radioButtonYes.id -> binding.textFrag.setText(R.string.yes_message)
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SimpleFragment()
    }
}
