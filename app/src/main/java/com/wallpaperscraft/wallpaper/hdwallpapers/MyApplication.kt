package com.wallpaperscraft.wallpaper.hdwallpapers

import android.app.Application
import android.os.Environment
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import android.os.Environment.getExternalStorageDirectory
import com.facebook.cache.disk.DiskCacheConfig
import java.io.File


class MyApplication : Application() {

    private lateinit var diskCacheConfig: DiskCacheConfig
    companion object {
        lateinit var instance: MyApplication
        //private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        //Fresco config
        enableCaching()
        val config = ImagePipelineConfig.newBuilder(instance)
            .setDownsampleEnabled(true)
            .setMainDiskCacheConfig(diskCacheConfig)
            .build()
        Fresco.initialize(this,config)
    }

    private fun enableCaching() {
             diskCacheConfig = DiskCacheConfig.newBuilder(instance)
            .setBaseDirectoryPath(File(getExternalStorageDirectory().getAbsoluteFile(), packageName))
            .setBaseDirectoryName("HDWallpapers")
            .build()
    }

}