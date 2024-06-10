package com.nc.dragonbites.data.remote.response

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("title")
    val title: String
)