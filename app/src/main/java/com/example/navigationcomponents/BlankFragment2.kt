package com.example.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.navigationcomponents.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {
    lateinit var binding: FragmentBlank2Binding

    private val sampleViewModel : SampleViewModel by activityViewModels()


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sampleViewModel.name.observe(viewLifecycleOwner){name->
            binding.txtName2.text=name
        }
        sampleViewModel.age.observe(viewLifecycleOwner){age->
            binding.txtAge2.text=age
        }
    }

}