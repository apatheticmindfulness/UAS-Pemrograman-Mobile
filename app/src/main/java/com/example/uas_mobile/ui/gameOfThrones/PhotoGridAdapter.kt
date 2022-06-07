package com.example.uas_mobile.ui.gameOfThrones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_mobile.databinding.GridViewItemBinding
import com.example.uas_mobile.network.GameOfThronesData

class PhotoGridAdapter :
    ListAdapter<GameOfThronesData, PhotoGridAdapter.MarsPhotosViewHolder>(DiffCallback) {

    /**
     * The MarsPhotosViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsPhoto] information.
     */
    class MarsPhotosViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPhoto: GameOfThronesData) {
            binding.photo = marsPhoto
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<GameOfThronesData>() {
        override fun areItemsTheSame(oldItem: GameOfThronesData, newItem: GameOfThronesData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GameOfThronesData, newItem: GameOfThronesData): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarsPhotosViewHolder {
        return MarsPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}


/*
class PhotoGridAdapter : ListAdapter<DisneyPhoto,
        PhotoGridAdapter.DisneyPhotoViewHolder>(DiffCallback) {

    class DisneyPhotoViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(MarsPhoto: DisneyPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DisneyPhoto>() {
        override fun areItemsTheSame(oldItem: DisneyPhoto, newItem: DisneyPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DisneyPhoto, newItem: DisneyPhoto): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.DisneyPhotoViewHolder {
        return DisneyPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.DisneyPhotoViewHolder, position: Int) {
        val disneyPhoto = getItem(position)
        holder.bind(disneyPhoto)
    }
}

*/