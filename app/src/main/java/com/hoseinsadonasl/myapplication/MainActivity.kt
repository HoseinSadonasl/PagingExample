package com.hoseinsadonasl.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.hoseinsadonasl.myapplication.databinding.ActivityMainBinding
import com.hoseinsadonasl.myapplication.objects.Item

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        val mainActivityAdapter = MainActivityAdapter()

        val get = ViewModelProvider(this).get(MainViewModel::class.java)

        get.itemPagedList.observe(this,
        object :Observer<PagedList<Item>>{
            override fun onChanged(t: PagedList<Item>?) {
            mainActivityAdapter.submitList(t)
            }
        })

        binding.rv.adapter= mainActivityAdapter
    }
}