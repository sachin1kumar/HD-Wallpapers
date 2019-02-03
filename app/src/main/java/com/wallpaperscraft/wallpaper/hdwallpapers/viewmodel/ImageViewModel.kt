package com.wallpaperscraft.wallpaper.images.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.wallpaperscraft.wallpaper.images.model.ImagesURI

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private var listOfDashdata: MutableLiveData< HashMap<String,List<String> >>? = null

    private fun getMutableDashRef(): MutableLiveData< HashMap<String,List<String> >>{
        if (listOfDashdata==null){
            listOfDashdata= MutableLiveData()
        }
        return listOfDashdata as MutableLiveData< HashMap<String,List<String> >>
    }

    fun getDashboardData() : MutableLiveData< HashMap<String,List<String>> >{
        var listOfUri = getMutableDashRef()
        listOfUri.value=ImagesURI.getDashboardData()
        return listOfUri
    }

}