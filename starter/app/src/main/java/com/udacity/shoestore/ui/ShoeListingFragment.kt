package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ItemShoeBinding

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.linearLayout.removeAllViews()
        viewModel.getListShoe()
        viewModel.getListShoeLiveData.observe(viewLifecycleOwner) { list ->
            list.forEach { item ->
                val view = ItemShoeBinding.inflate(layoutInflater).apply {
                    shoe = item
                    btnDetail.setOnClickListener {
                        findNavController().navigate(
                            ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment(
                                item
                            )
                        )
                    }
                }.root
                binding.linearLayout.addView(view)
            }
        }
        binding.imgMenu.setOnClickListener {
            (requireActivity() as MainActivity).openMenu()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.linearLayout.removeAllViews()
    }

}