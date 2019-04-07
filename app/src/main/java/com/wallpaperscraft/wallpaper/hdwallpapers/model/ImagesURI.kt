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



        private val listOftallrending = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_trending_list
        ).toList()

        private val listOfallAbstract = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_abstract_list
        ).toList()

        private val listOfallNature = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_nature_list
        ).toList()

        private val listOfallMusic = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_music_list
        ).toList()

        private val listOfallVehicle = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_music_list
        ).toList()

        private val listOfalltech = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_technology_list
        ).toList()

        private val listOfallAnimal = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_animal_list
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

        fun getSeellAllData(cat: String) : List<String>?{
            var list: List<String> ?= null
            when (cat) {
                MyApplication.instance.getString(R.string.text_cat_first) -> list = listOftallrending
                MyApplication.instance.getString(R.string.text_cat_second) -> list = listOfallAbstract
                MyApplication.instance.getString(R.string.text_cat_third) -> list = listOfallNature
                MyApplication.instance.getString(R.string.text_cat_fourth) -> list = listOfallMusic
                MyApplication.instance.getString(R.string.text_cat_fifth) -> list = listOfallVehicle
                MyApplication.instance.getString(R.string.text_cat_sixth) -> list = listOfalltech
                MyApplication.instance.getString(R.string.text_cat_seventh) -> list = listOfallAnimal
            }

            return list
        }


    }

}