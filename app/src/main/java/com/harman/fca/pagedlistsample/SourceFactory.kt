package com.harman.fca.pagedlistsample

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource

class SourceFactory : DataSource.Factory<Int, Item>() {

    //val itemLiveDataSource : MutableLiveData<PageKeyedDataSource<Int, Item>> =  MutableLiveData()

    override fun create(): DataSource<Int, Item> {
        val data =  DataSource()
        //itemLiveDataSource.postValue(data)
        return data
    }
}