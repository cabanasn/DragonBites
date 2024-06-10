package com.nc.dragonbites.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

@ProvidedTypeConverter
class MethodConverter @Inject constructor(
    private val gson: Gson
){
    @TypeConverter
    fun fromStringToMap(value: String): List<Map<String, String>> {
        val mapType = object : TypeToken<List<Map<String, String>>>() {}.type
        return gson.fromJson(value, mapType)
    }

    @TypeConverter
    fun fromMapToList(value: List<Map<String, String>>): String {
        return gson.toJson(value)
    }
}