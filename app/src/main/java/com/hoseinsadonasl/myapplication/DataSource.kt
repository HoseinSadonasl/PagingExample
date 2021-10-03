package com.hoseinsadonasl.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.hoseinsadonasl.myapplication.app.RetrofitClient
import com.hoseinsadonasl.myapplication.objects.Item
import com.hoseinsadonasl.myapplication.objects.Response
import retrofit2.Call
import retrofit2.Callback


class WorkDataSource : PageKeyedDataSource<Int, Item>() {

    companion object {
        const val PAGING_ROWS = 10;
        const val PAGING_OFFSET = 0
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Item>
    ) {
        RetrofitClient.getApi().getWorks(PAGING_OFFSET, PAGING_ROWS)
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    val body = response.body()
                    callback.onResult(response.body()!!.message.items, null, PAGING_OFFSET + 1)
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {

                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.getApi().getWorks(params.key * PAGING_ROWS, PAGING_ROWS)
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.body() != null) {
                        val key =
                            if (response.body()!!.message.items.size == PAGING_ROWS) params.key + 1 else null

                        callback.onResult(response.body()!!.message.items, key)
                    }
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {

                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        RetrofitClient.getApi().getWorks(params.key * PAGING_ROWS, PAGING_ROWS)
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    val adjacentKey = if (params.key > 1) params.key - 1 else null

                    if (response.body() != null) {
                        callback.onResult(response.body()!!.message.items, adjacentKey)
                    }
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {

                }
            })
    }
}


class WorkDataSourceFactory : DataSource.Factory<Int, Item>() {
    private var itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Item>>()

    override fun create(): DataSource<Int, Item> {
        val itemDataSource = WorkDataSource()

        itemLiveDataSource.postValue(itemDataSource)

        return itemDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Item>> {
        return itemLiveDataSource
    }

}