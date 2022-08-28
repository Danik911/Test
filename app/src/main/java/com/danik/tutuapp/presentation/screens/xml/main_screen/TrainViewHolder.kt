package com.danik.tutuapp.presentation.screens.xml.main_screen

import androidx.recyclerview.widget.RecyclerView
import com.danik.tutuapp.databinding.TrainItemBinding
import com.danik.tutuapp.domain.model.Train

class TrainViewHolder(
    private val binding: TrainItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(train: Train) {
        binding.apply {
            //binding.heroImageView = train.image
            binding.heroNameTextView.text = train.model
            binding.heroDescriptionTextView.text = train.about
        }
    }
}