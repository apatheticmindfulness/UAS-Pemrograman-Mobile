package com.example.uas_mobile.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.uas_mobile.databinding.FragmentHomeBinding
import com.example.uas_mobile.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSlideshowBinding.inflate(inflater)

        return binding.root
    }


}