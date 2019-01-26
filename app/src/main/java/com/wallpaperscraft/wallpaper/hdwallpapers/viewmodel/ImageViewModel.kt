package com.wallpaperscraft.wallpaper.images.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.wallpaperscraft.wallpaper.images.model.ImagesURI

class ImageViewModel(application: Application) : AndroidViewModel(application) {


    fun getDashboardImage() : String {
        return ImagesURI.getDashboardURI();
    }


}