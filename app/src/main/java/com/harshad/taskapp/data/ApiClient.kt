package com.harshad.taskapp.data

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    companion object {
        var BASE_URL = "https://api.thecatapi.com/v1/images"

        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiClient::class.java)
        }
    }

    @GET("/search?limit=100&")
    suspend fun getImages(@Query("page") page: Int): Call<MutableLiveData<List<Response?>>?>

}