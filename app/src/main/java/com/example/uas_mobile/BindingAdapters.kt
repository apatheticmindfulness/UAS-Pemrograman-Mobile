package com.example.uas_mobile

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.uas_mobile.network.BreakingBadPhoto
import com.example.uas_mobile.network.DisneyPhoto
import com.example.uas_mobile.ui.disney.DisneyViewModel.DisneyApiStatus
import com.example.uas_mobile.ui.disney.PhotoGridAdapter
import com.example.uas_mobile.ui.disney.PhotoGridAdapter2
import com.example.uas_mobile.ui.slideshow.SlideshowViewModel
import com.example.uas_mobile.ui.slideshow.SlideshowViewModel.DisneyApiStatus2

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<DisneyPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData2")
fun bindRecyclerView2(recyclerView: RecyclerView,
                     data: List<BreakingBadPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter2
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_baseline_broken_image_24)
        }
    }
}

@BindingAdapter("disneyApiStatus")
fun bindStatus(statusImageView: ImageView, status: DisneyApiStatus?) {
    when(status){
        DisneyApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DisneyApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error  )
        }
        DisneyApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("disneyApiStatus2")
fun bindStatus(statusImageView: ImageView, status: DisneyApiStatus2?) {
    when(status){
        DisneyApiStatus2.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DisneyApiStatus2.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error  )
        }
        DisneyApiStatus2.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}



