package com.example.uas_mobile.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.uas_mobile.databinding.FragmentHomeBinding
import com.example.uas_mobile.databinding.FragmentSlideshowBinding
import com.example.uas_mobile.ui.disney.DisneyViewModel
import com.example.uas_mobile.ui.disney.PhotoGridAdapter2

class SlideshowFragment : Fragment() {

    private val viewModel: SlideshowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSlideshowBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter2()
        return binding.root
    }


}