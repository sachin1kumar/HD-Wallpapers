package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.wallpaperscraft.wallpaper.images.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var catRecyclerView: RecyclerView
    private var listOfDashData: Pair<List<String>,List<String>>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)

        catRecyclerView = findViewById(R.id.list)

        (viewModel as ImageViewModel).getDashboardData().observe(
            this, android.arch.lifecycle.Observer {
                listOfDashData = it!!
                var catAdapter = ListOfCatAdapter(listOfDashData!!)
                var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                catRecyclerView.layoutManager = mLayoutManager
                catRecyclerView.itemAnimator
                catRecyclerView.isNestedScrollingEnabled = false
                catRecyclerView.setHasFixedSize(true)
                catRecyclerView.adapter = catAdapter
            })

    }
}
