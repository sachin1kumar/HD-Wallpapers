package com.wallpaperscraft.wallpaper.hdwallpapers

import android.app.Application
import android.content.Context
import android.os.Environment
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import android.os.Environment.getExternalStorageDirectory
import com.facebook.cache.disk.DiskCacheConfig
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager




class MyApplication : Application() {

    private lateinit var diskCacheConfig: DiskCacheConfig
    private lateinit var mStorageRef: StorageReference

    companion object {
        lateinit var instance: MyApplication
            //private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mStorageRef = FirebaseStorage.getInstance().reference
        //Fresco config
        enableCaching()
        val config = ImagePipelineConfig.newBuilder(instance)
            .setDownsampleEnabled(true)
            .setMainDiskCacheConfig(diskCacheConfig)
            .build()
        Fresco.initialize(this, config)
    }

    private fun enableCaching() {
        diskCacheConfig = DiskCacheConfig.newBuilder(instance)
            .setBaseDirectoryPath(File(getExternalStorageDirectory().getAbsoluteFile(), packageName))
            .setBaseDirectoryName("HDWallpapers")
            .build()
    }


    fun isNetworkConnected(): Boolean {
        val cm = instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }


}