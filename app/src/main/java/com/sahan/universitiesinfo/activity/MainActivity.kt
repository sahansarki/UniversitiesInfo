package com.sahan.universitiesinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahan.universitiesinfo.R
import com.sahan.universitiesinfo.adapter.RecyclerAdapter
import com.sahan.universitiesinfo.databinding.ActivityMainBinding
import com.sahan.universitiesinfo.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: MainActivityViewModel
    private val universtyAdapter = RecyclerAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val rcUniversities = binding.rcUniversities

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        rcUniversities.layoutManager = LinearLayoutManager(this)
        rcUniversities.adapter = universtyAdapter

        initializeSpinner(binding)
        observeLiveData()
        //viewModel.getUniversities()
    }


    fun initializeSpinner(binding: ActivityMainBinding) {
        val spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.countries_array,
            android.R.layout.simple_spinner_item,
        ).also { arrayAdapter ->

            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
            spinner.onItemSelectedListener = this

        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        /**
         * Internetten seçili ülkenin okul verileri çekilecek
         * Bu işlem coroutine ile viewmodel içerisinde yapılacak
         *
         */
        viewModel.getUniversitiesByItem((parent?.getItemAtPosition(p2)).toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        return
    }


    private fun observeLiveData() {
        viewModel.universities.observe(
            this, {
                universtyAdapter.changeUniversityList(it)

            }
        )
    }


}