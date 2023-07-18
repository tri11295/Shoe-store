package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val args: ShoeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoe = args.shoe

        binding.btnSave.setOnClickListener {
            val newShoe = Shoe(
                args.shoe.id,
                binding.edtName.text.toString(),
                binding.edtSize.text.toString().toDouble(),
                binding.edtCompany.text.toString(),
                binding.edtDescription.text.toString()
            )
            viewModel.updateShoeInfo(newShoe)
            findNavController().navigateUp()
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}