package com.harman.fca.pagedlistsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainViewModel : ViewModel() {

    val pagedList: LiveData<PagedList<Item>>
    //val itemPagedList : LiveData<PageKeyedDataSource<Int, Item>>

    private val BASE_URL = "https://howtodoinjava.com/"

    private val builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(SimpleXmlConverterFactory.create())
    init {
        val factory = SourceFactory()
        //itemPagedList = factory.itemLiveDataSource

        val config =
            PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(DataSource.SIZE)
                .build()

        pagedList = LivePagedListBuilder(factory, config).build()


        val retrofit = builder.build();

        val rssService = retrofit.create(Apixml::class.java)

        val callAsync = rssService.getXMLResponse();

        callAsync.enqueue(object : Callback<SampleXmlDataPojo> {
            override fun onResponse(
                call: Call<SampleXmlDataPojo>,
                response: Response<SampleXmlDataPojo>
            ) {
                Log.i("Arpit","success" +response?.body()?.channel?.title)
            }

            override fun onFailure(call: Call<SampleXmlDataPojo>, t: Throwable) {
                Log.i("Arpit","fail" )
            }

        });
    }
}