package com.nc.dragonbites.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecipeDetail(
    @SerializedName("description")
    val description: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("ingredients")
    val ingredients: List<String>,

    @SerializedName("method")
    val method: List<Map<String, String>>,

    @SerializedName("portion")
    val portion: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("title")
    val title: String
)