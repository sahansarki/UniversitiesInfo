package com.sahan.universitiesinfo.viewmodel

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahan.universitiesinfo.model.University
import com.sahan.universitiesinfo.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedFragmentViewModel : ViewModel() {


    private val apiService = APIService()

    private var _universities = MutableLiveData<ArrayList<University>>()
    var universities =  _universities



    fun getUniversitiesByItem(spinnerItem: String) {


        val call = apiService.getData(spinnerItem)
        call.enqueue(object : Callback<ArrayList<University>> {

            override fun onResponse(
                call: Call<ArrayList<University>>,
                response: Response<ArrayList<University>>
            ) {
                if (response.isSuccessful) {
                    response.body().let {
                        _universities.value = it
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<University>>, t: Throwable) {
                println(Log.e("Error","The data couldnt have been fetched"))
            }


        })
    }


}