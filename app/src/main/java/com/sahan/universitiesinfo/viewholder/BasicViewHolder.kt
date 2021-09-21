package com.sahan.universitiesinfo.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sahan.universitiesinfo.databinding.AdapterSchoolItemBinding
import com.sahan.universitiesinfo.model.University

class BasicViewHolder(private val binding: AdapterSchoolItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(university: University) {
        binding.universty = university
    }
}