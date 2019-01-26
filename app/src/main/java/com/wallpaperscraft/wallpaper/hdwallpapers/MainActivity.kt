package com.wallpaperscraft.wallpaper.hdwallpapers

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.images.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)

        val draweeView = findViewById(R.id.main_logo) as SimpleDraweeView
        draweeView.setImageURI((viewModel as ImageViewModel).getDashboardImage())

    }
}
