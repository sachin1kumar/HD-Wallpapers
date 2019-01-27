package com.wallpaperscraft.wallpaper.images.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.wallpaperscraft.wallpaper.images.model.ImagesURI

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private var listOfDashdata: MutableLiveData< Pair<List<String>,List<String>> >? = null

    private fun getMutableDashRef(): MutableLiveData< Pair<List<String>,List<String>> >{
        if (listOfDashdata==null){
            listOfDashdata= MutableLiveData()
        }
        return listOfDashdata as MutableLiveData< Pair<List<String>,List<String>> >
    }

    fun getDashboardData() : MutableLiveData< Pair<List<String>,List<String>> > {
        var listOfUri = getMutableDashRef()
        listOfUri.value=ImagesURI.getDashboardData()
        return listOfUri
    }

}