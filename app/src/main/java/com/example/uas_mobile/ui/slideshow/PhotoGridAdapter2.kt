package com.example.uas_mobile.ui.gameOfThrones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_mobile.databinding.GridViewItem2Binding
import com.example.uas_mobile.network.BreakingBadPhoto

class PhotoGridAdapter2 :
    ListAdapter<BreakingBadPhoto, PhotoGridAdapter2.MarsPhotosViewHolder2>(DiffCallback) {

    /**
     * The MarsPhotosViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsPhoto] information.
     */
    class MarsPhotosViewHolder2(
        private var binding: GridViewItem2Binding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPhoto: BreakingBadPhoto) {
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
    companion object DiffCallback : DiffUtil.ItemCallback<BreakingBadPhoto>() {
        override fun areItemsTheSame(oldItem: BreakingBadPhoto, newItem: BreakingBadPhoto): Boolean {
            return oldItem.char_id == newItem.char_id
        }

        override fun areContentsTheSame(oldItem: BreakingBadPhoto, newItem: BreakingBadPhoto): Boolean {
            return oldItem.img == newItem.img
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarsPhotosViewHolder2 {
        return MarsPhotosViewHolder2(
            GridViewItem2Binding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */


    override fun onBindViewHolder(holder: MarsPhotosViewHolder2, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}