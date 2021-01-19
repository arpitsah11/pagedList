package com.harman.fca.pagedlistsample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val URL = "https://api.stackexchange.com/2.2/"
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApi():Api{
        return retrofit.create(Api::class.java)
    }
}