package com.sahan.universitiesinfo.viewholder

import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sahan.universitiesinfo.databinding.AdapterSchoolItemBinding
import com.sahan.universitiesinfo.fragment.FeedFragmentDirections
import com.sahan.universitiesinfo.model.University

class BasicViewHolder(private val binding: AdapterSchoolItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(university: University) {
        binding.universty = university

        binding.cardschool.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment(university.webPages[0])
            Navigation.findNavController(binding.root).navigate(action)

        }

    }


}