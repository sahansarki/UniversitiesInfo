package com.sahan.universitiesinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sahan.universitiesinfo.R
import com.sahan.universitiesinfo.databinding.AdapterSchoolItemBinding
import com.sahan.universitiesinfo.model.University
import com.sahan.universitiesinfo.viewholder.BasicViewHolder

class RecyclerAdapter(var universityList: ArrayList<University>) :
    RecyclerView.Adapter<BasicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterSchoolItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.adapter_school_item,
            parent,
            false
        )
        return BasicViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        holder.bind(universityList[position])
    }

    override fun getItemCount(): Int {
        return universityList.size
    }

    fun changeUniversityList(newList: ArrayList<University>) {
        this.universityList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }


}