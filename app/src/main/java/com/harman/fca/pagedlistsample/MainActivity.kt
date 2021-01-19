package com.harman.fca.pagedlistsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val viewModel : MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    lateinit var view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view = findViewById(R.id.recycler_view)
        view.layoutManager = LinearLayoutManager(this)
        view.setHasFixedSize(true)

        val adapter = SamplePagedListAdapter(this)
        viewModel.pagedList.observe(this,
            {
                adapter.submitList(it)
            })
        view.adapter = adapter
    }
}