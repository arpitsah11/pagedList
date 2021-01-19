package com.harman.fca.pagedlistsample

import retrofit2.Call
import retrofit2.http.GET

interface Apixml {

    @GET("feed")
    fun getXMLResponse(): Call<SampleXmlDataPojo>
}