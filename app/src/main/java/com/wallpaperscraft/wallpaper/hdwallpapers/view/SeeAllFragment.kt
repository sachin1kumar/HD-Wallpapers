package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.wallpaperscraft.wallpaper.images.viewmodel.ImageViewModel
import android.support.v7.app.AppCompatActivity
import com.startapp.android.publish.ads.banner.Banner


class SeeAllFragment(context:Context) : Fragment(){

    private lateinit var viewModel: ViewModel
    private lateinit var seeallRecyclerView: RecyclerView
    @get:JvmName("getContext_")
    private lateinit var view: View
    private lateinit var toolbar: Toolbar
    private lateinit var seeAll: String
    private lateinit var listOfData: List<String>
    private lateinit var title: TextView
    private var banner: Banner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view= inflater.inflate(R.layout.see_all_images, container, false)
        toolbar = view.findViewById(R.id.see_all_tool_bar)
        seeallRecyclerView = view.findViewById(R.id.see_all_list)
        title = view.findViewById(R.id.toolbar_title)
        title.text = seeAll
        banner = view.findViewById(R.id.startAppBanner2)
        banner!!.showBanner()

        (viewModel as ImageViewModel).getSeeAllList(seeAll)!!.observe(
            this, android.arch.lifecycle.Observer {
                listOfData = it!!
                var catAdapter = SeeAllAdapter(listOfData,context!!)
                var mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity,4) as RecyclerView.LayoutManager
                seeallRecyclerView.layoutManager = mLayoutManager
                seeallRecyclerView.itemAnimator
                seeallRecyclerView.isNestedScrollingEnabled = false
                seeallRecyclerView.setHasFixedSize(true)
                seeallRecyclerView.adapter = catAdapter
            })
        return view
    }

    fun setData(cat: TextView){
        seeAll = cat.getTag().toString()
    }
}