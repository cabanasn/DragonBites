package com.nc.dragonbites.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nc.dragonbites.data.local.RecipesDatabase
import com.nc.dragonbites.data.local.converters.IngredientsConverter
import com.nc.dragonbites.data.local.converters.MethodConverter
import com.nc.dragonbites.data.remote.DragonBitesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val headersInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", DragonBitesAPI.API_KEY)
            .addHeader("x-rapidapi-host", DragonBitesAPI.API_HOST)
            .build()
        chain.proceed(request)
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headersInterceptor)
        .build()

    @Singleton
    @Provides
    fun providesDragonBitesAPI(): DragonBitesAPI {
        return Retrofit.Builder()
            .baseUrl(DragonBitesAPI.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DragonBitesAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun providesRecipesDatabase(app: Application, gson: Gson): RecipesDatabase {
        return Room.databaseBuilder(app, RecipesDatabase::class.java,
            "recipes_database.db")
            .addTypeConverter(IngredientsConverter(gson))
            .addTypeConverter(MethodConverter(gson))
            .fallbackToDestructiveMigration()
            .build()
    }



}