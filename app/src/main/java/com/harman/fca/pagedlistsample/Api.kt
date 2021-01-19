package com.harman.fca.pagedlistsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("answers")
    fun getResponse(
        @Query("page") page: Int,
        @Query("pagesize") pagesize: Int,
        @Query("site") site: String
    ): Call<ApiData>
    
}