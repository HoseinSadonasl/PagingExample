package com.hoseinsadonasl.myapplication

import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource

import androidx.lifecycle.LiveData

import com.hoseinsadonasl.myapplication.objects.Item
import androidx.paging.LivePagedListBuilder

import androidx.paging.PagedList

class MainViewModel: ViewModel() {

    var itemPagedList: LiveData<PagedList<Item>>
    var liveDataSource: LiveData<PageKeyedDataSource<Int, Item>>

    init {
        val workDataSourceFactory = WorkDataSourceFactory()

        liveDataSource = workDataSourceFactory.getItemLiveDataSource()

        val pagedListConfig: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10).build()

        itemPagedList = LivePagedListBuilder(workDataSourceFactory, pagedListConfig).build()

    }
}