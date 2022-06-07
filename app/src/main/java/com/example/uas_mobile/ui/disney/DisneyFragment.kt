package com.example.uas_mobile.ui.disney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.uas_mobile.databinding.FragmentDisneyBinding


class DisneyFragment : Fragment() {


    private val viewModel: DisneyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDisneyBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }


}