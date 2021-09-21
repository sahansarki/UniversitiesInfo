package com.sahan.universitiesinfo.model

import com.google.gson.annotations.SerializedName

data class University(
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("alpha_two_code")
    val alphaCode: String,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("web_pages")
    val webPages: List<String>
)