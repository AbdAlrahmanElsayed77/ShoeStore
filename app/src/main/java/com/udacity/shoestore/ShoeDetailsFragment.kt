package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.viewModel = viewModel
        binding.addBtn.setOnClickListener {
                viewModel.addShoe()
                findNavController().popBackStack()
        }
        binding.cancelBtn.setOnClickListener {
            viewModel.clear()
            findNavController().popBackStack()
        }
        viewModel.clear()
        viewModel.shoeIndex.observe(viewLifecycleOwner, Observer { getImage()})
        return binding.root
    }
    fun getImage() {
        binding.chooseShoeImage.setImageResource(viewModel.getImage())
    }
}