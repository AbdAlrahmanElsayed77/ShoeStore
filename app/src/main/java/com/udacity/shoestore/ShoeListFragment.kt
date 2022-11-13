package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemsBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        val list = viewModel.shoeList.value
        if (list != null) {
            for (element in list) {
                val newShoe: ShoeItemsBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_items, container, false)
                newShoe.name.text = element.name
                newShoe.size.text = element.size.toString()
                newShoe.company.text = element.company
                newShoe.image.setImageResource(element.index)
                binding.linearLayout.addView(newShoe.root)
            }
        }
        binding.addShoe.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.loginFragment ->{
                this.findNavController().popBackStack(R.id.loginFragment,false)
                true
            }else -> false
        }
    }
}