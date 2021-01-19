package com.harman.fca.pagedlistsample

import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSource : PageKeyedDataSource<Int, Item>() {

    companion object {
        val SIZE = 100
        private val SITE = "stackoverflow"
        private val FIRST_PAGE = 1

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Item>
    ) {
        RetrofitClient.getApi().getResponse(FIRST_PAGE, SIZE, SITE).enqueue(object :
            Callback<ApiData> {
            override fun onFailure(call: Call<ApiData>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ApiData>?, response: Response<ApiData>?) {
                response?.body()?.items?.let { callback.onResult(it, null, FIRST_PAGE + 1) }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.getApi().getResponse(params.key, SIZE, SITE).enqueue(object :
            Callback<ApiData> {
            override fun onFailure(call: Call<ApiData>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ApiData>?, response: Response<ApiData>?) {
                var key = if (params.key > 1) {
                    params.key-1
                } else {
                    null
                }
                if(key != null)
                response?.body()?.items?.let { callback.onResult(it, key ) }
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.getApi().getResponse(params.key, SIZE, SITE).enqueue(object :
            Callback<ApiData> {
            override fun onFailure(call: Call<ApiData>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ApiData>?, response: Response<ApiData>?) {
                var key = null
                if(response?.body() != null){
                    var key = if(response?.body()!!.has_more){
                        params.key.plus(1)
                    }else{
                        null
                    }
                }
                response?.body()?.items?.let { callback.onResult(it, key ) }
            }
        })
    }
}