package com.sahan.universitiesinfo.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahan.universitiesinfo.model.University
import com.sahan.universitiesinfo.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel : ViewModel() {

    private var selectedItem: String = ""
    private val apiService = APIService()


    var universities =  MutableLiveData<ArrayList<University>>()



    fun getUniversitiesByItem(spinnerItem: String) {
        selectedItem = spinnerItem

        val call = apiService.getData(selectedItem)
        call.enqueue(object : Callback<ArrayList<University>> {

            override fun onResponse(
                call: Call<ArrayList<University>>,
                response: Response<ArrayList<University>>
            ) {
                if (response.isSuccessful) {
                    response.body().let {
                        universities.value = it
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<University>>, t: Throwable) {
                println(Log.e("Error","The data couldnt have been fetched"))
            }


        })
    }


}