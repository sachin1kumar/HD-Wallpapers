package com.wallpaperscraft.wallpaper.images.model

import android.net.Uri
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.backends.pipeline.PipelineDraweeController
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.facebook.imagepipeline.request.ImageRequest



class ImagesURI {

    companion object {

        private val listOfUris = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.list_of_uri).toList()

        private val listOfCats = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.list_of_categories).toList()


        fun getDashboardData(): Pair<List<String>,List<String>> {
            return Pair(listOfUris, listOfCats)
        }

    }

}