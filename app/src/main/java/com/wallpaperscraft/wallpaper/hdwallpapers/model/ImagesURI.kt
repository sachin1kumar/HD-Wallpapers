package com.wallpaperscraft.wallpaper.images.model

import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R


class ImagesURI {

    companion object {

        private val listOftrending = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.trending_list
        ).toList()

        private val listOfAbstract = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.abstract_list
        ).toList()

        private val listOfNature = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.nature_list
        ).toList()

        private val listOfMusic = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.music_list
        ).toList()

        private val listOfVehicle = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.vehicle_list
        ).toList()

        private val listOftech = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.technology_list
        ).toList()

        private val listOfAnimal = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.animal_list
        ).toList()

        private val listOfCats = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.list_of_categories
        ).toList()


        private lateinit var hashMap: HashMap<String, List<String>>


        fun getDashboardData(): HashMap<String, List<String>> {
            return createHashMap()
        }


        fun createHashMap(): HashMap<String, List<String>> {
            hashMap = HashMap()
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_first), listOftrending)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_second), listOfAbstract)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_third), listOfNature)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_fourth), listOfMusic)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_fifth), listOfVehicle)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_sixth), listOftech)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_seventh), listOfAnimal)
            return hashMap
        }


    }

}