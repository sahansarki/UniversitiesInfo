package com.sahan.universitiesinfo.network

import com.sahan.universitiesinfo.model.University
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("search?&?")
    fun getUniversities(@Query("country") country: String) : Call<ArrayList<University>>
}