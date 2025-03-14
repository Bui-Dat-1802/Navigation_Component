package com.example.navigationcomponents

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponents.databinding.FragmentBlankBinding

//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [BlankFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
class BlankFragment : Fragment() {
    private  lateinit var  navController: NavController

    private lateinit var binding:FragmentBlankBinding

    private  val sampleViewModel : SampleViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


//        truyền dữ liệu liên tục cho liveData khi nhập dữ liệu
        binding.editName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    sampleViewModel._name.value = s.toString()
                    sampleViewModel._numOfChar.value = s.toString()?.length?: 0
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.btnFrag2.setOnClickListener{
            sampleViewModel.updateName(binding.editName.text.toString())
            sampleViewModel.updateAge(binding.editAge.text.toString())
            navController.navigate(R.id.action_blankFragment_to_blankFragment2)

        }

//        update txtName liên tục khi nhập
        sampleViewModel.name.observe(viewLifecycleOwner){name->
            binding.txtName.setText(name.uppercase())
        }
        sampleViewModel._numOfChar.observe(viewLifecycleOwner){numOfChar->
            binding.txtNumOfChar.setText(numOfChar.toString())
        }


    }
}