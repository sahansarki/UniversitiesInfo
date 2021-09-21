package com.sahan.universitiesinfo.network

import com.sahan.universitiesinfo.model.University
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {

    private val BASE_URL = "http://universities.hipolabs.com/"


    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API::class.java)

    fun getData(country: String) : Call<ArrayList<University>> {
        return api.getUniversities(country)
    }
}