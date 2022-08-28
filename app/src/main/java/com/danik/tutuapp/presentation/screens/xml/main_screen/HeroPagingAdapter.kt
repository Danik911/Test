package com.danik.tutuapp.presentation.screens.xml.main_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.danik.tutuapp.databinding.TrainItemBinding
import com.danik.tutuapp.domain.model.Train

class TrainAdapter : PagingDataAdapter<Train, TrainViewHolder>(TRAIN_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder =
        TrainViewHolder(
            TrainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        val tile = getItem(position)
        if (tile != null) {
            holder.bind(tile)
        }
    }

    companion object {
        private val TRAIN_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Train>() {
            override fun areItemsTheSame(oldItem: Train, newItem: Train): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Train, newItem: Train): Boolean =
                oldItem == newItem
        }
    }
}

