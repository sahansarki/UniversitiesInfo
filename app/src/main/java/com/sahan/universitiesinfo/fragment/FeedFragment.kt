package com.sahan.universitiesinfo.fragment

import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahan.universitiesinfo.R
import com.sahan.universitiesinfo.adapter.RecyclerAdapter
import com.sahan.universitiesinfo.databinding.FragmentFeedBinding
import com.sahan.universitiesinfo.viewmodel.FeedFragmentViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : BaseFragment<FragmentFeedBinding>(), AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: FeedFragmentViewModel
    private  var selectedItem: String = ""
    private var previousItem: String = ""
    private val universtyAdapter = RecyclerAdapter(arrayListOf())

    override fun getLayoutId(): Int {
        return R.layout.fragment_feed
    }

    override fun initUi() {
        val rcUniversities = fragmentDataBinding.rcUniversities
        viewModel = ViewModelProvider(this)[FeedFragmentViewModel::class.java]
        rcUniversities.layoutManager = LinearLayoutManager(requireContext())
        rcUniversities.adapter = universtyAdapter

        initializeSpinner()
        observeLiveData()

    }

    fun initializeSpinner() {
        val spinner = fragmentDataBinding.spinner
        ArrayAdapter.createFromResource(
            requireContext(),
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
        selectedItem = parent?.getItemAtPosition(p2).toString()

        if(selectedItem != previousItem) {
            previousItem = selectedItem
            viewModel.getUniversitiesByItem((parent?.getItemAtPosition(p2)).toString())
        }

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



    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }


}