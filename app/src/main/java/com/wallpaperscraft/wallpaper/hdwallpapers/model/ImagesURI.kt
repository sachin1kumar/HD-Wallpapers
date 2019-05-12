package com.wallpaperscraft.wallpaper.images.model

import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager



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

        private val listOfMotivation = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.motivation_list
        ).toList()



        private val listOftallrending = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_trending_list
        ).toList()


        private val listOfallMusic = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_music_list
        ).toList()

        private val listOfallVehicle = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_vehicle_list
        ).toList()

        private val listOfalltech = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_technology_list
        ).toList()


        private val listOfallMotivation = MyApplication.instance.applicationContext.resources.getStringArray(
            R.array.seeall_motivation_list
        ).toList()



        private lateinit var hashMap: HashMap<String, List<String>>


        fun getDashboardData(): HashMap<String, List<String>> {
            return createHashMap()
        }


        fun createHashMap(): HashMap<String, List<String>> {
            hashMap = HashMap()
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_first), listOftrending)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_second), listOfNature)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_third), listOfAbstract)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_fourth), listOfMusic)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_fifth), listOfVehicle)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_sixth), listOftech)
            hashMap.put(MyApplication.instance.getString(R.string.text_cat_seventh), listOfMotivation)
            return hashMap
        }

        fun getSeellAllData(cat: String) : List<String>?{
            var list: List<String> ?= null
            when (cat) {
                MyApplication.instance.getString(R.string.text_cat_first) -> list = listOftallrending
                MyApplication.instance.getString(R.string.text_cat_second) -> list = listOfNature
                MyApplication.instance.getString(R.string.text_cat_third) -> list = listOfAbstract
                MyApplication.instance.getString(R.string.text_cat_fourth) -> list = listOfallMusic
                MyApplication.instance.getString(R.string.text_cat_fifth) -> list = listOfallVehicle
                MyApplication.instance.getString(R.string.text_cat_sixth) -> list = listOfalltech
                MyApplication.instance.getString(R.string.text_cat_seventh) -> list = listOfallMotivation
            }

            return list
        }


        fun getdisplayUrl(filename: String) : String{
            if (filename == "abstract_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_1_full.jpg?alt=media&token=68adefc8-848e-4c9d-b9f1-f83183bba412"
            }
            if (filename == "abstract_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_2_full.jpg?alt=media&token=96bebb1b-1865-4a4c-80c6-ccf2ea7f71ae"
            }
            if (filename == "abstract_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_3_full.jpg?alt=media&token=49a27f1d-d0ab-46c3-b4c7-aa2ea424c3ef"
            }
            if (filename == "abstract_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_4_full.jpg?alt=media&token=22b05f09-e49a-4dd8-91ea-2de2d54ec32a"
            }
            if (filename == "abstract_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_5_full.jpg?alt=media&token=73ebf45a-904d-4847-8c27-d444d30da2cc"
            }
            if (filename == "abstract_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_6_full.jpg?alt=media&token=011c8d25-0aa5-4a2b-93db-fd412c3354f1"
            }
            if (filename == "abstract_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_7_full.jpg?alt=media&token=af56345e-c345-4f90-b66b-cdf711d7cf17"
            }
            if (filename == "abstract_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_8_full.jpg?alt=media&token=7ec3c0e4-6d42-4349-8607-351edfad2bed"
            }
            if (filename == "abstract_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_10_full.jpg?alt=media&token=5fb43416-3130-4f4d-a194-ced4cf4ce1d7"
            }
            if (filename == "abstract_11"){
                return  "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_11_full.jpg?alt=media&token=a728954f-69ca-4b62-89dd-66825fe75886"
            }
            if (filename == "abstract_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_12_full.jpg?alt=media&token=9dd0517f-cf83-4645-88f0-5fd73d712e68"
            }
            if (filename == "abstract_13"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/abstract%2Fabstract_13_full.jpg?alt=media&token=caed855a-7893-4865-bcf5-779e7d4b8f69"
            }
            if (filename == "vehicle_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_1_full.jpg?alt=media&token=6d746609-263c-4ece-bd76-028dadd9eaf4"
            }
            if (filename == "vehicle_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_2_full.jpg?alt=media&token=83cd8796-75ca-484a-8409-009ac8319b3e"
            }
            if (filename == "vehicle_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_3_full.jpg?alt=media&token=1db1f03d-f62f-4881-b708-33256154a863"
            }
            if (filename == "vehicle_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_4_full.jpg?alt=media&token=94849048-00f6-4a10-bfd7-b15dac35adf1"
            }
            if (filename == "vehicle_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_5_full.jpg?alt=media&token=ad6929d1-8a1e-4cbc-b1b0-7acbf190c92d"
            }
            if (filename == "vehicle_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_6_full.jpg?alt=media&token=3ad287db-3ae8-40e7-b919-c4269438a925"
            }
            if (filename == "vehicle_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_7_full.jpg?alt=media&token=dd1b7421-a5d0-4e85-9df0-3e6d42fe7a21"
            }
            if (filename == "vehicle_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_8_full.jpg?alt=media&token=98333277-98be-42aa-a536-560273be2021"
            }
            if (filename == "vehicle_9"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_9_full.jpg?alt=media&token=cbf833f1-4116-4832-adea-d08a258949d2"
            }
            if (filename == "vehicle_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_10_full.jpg?alt=media&token=e1030429-6469-41b3-b7b3-741caf68e025"
            }
            if (filename == "vehicle_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_11_full.jpg?alt=media&token=792e7ad2-ab8e-466d-95bb-fb0a03ec30dd"
            }
            if (filename == "vehicle_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/cars%2Fvehicle_12_full.jpg?alt=media&token=43c72aff-cb3e-48b3-89e5-5f3318a70c55"
            }
            if (filename == "motivation_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_1_full.jpg?alt=media&token=a67a94b3-2367-4d7e-a317-d65d3f4350f1"
            }
            if (filename == "motivation_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_2_full.jpg?alt=media&token=4cf0aaf0-4fb8-4db3-9668-6ec72eead804"
            }
            if (filename == "motivation_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_3_full.jpg?alt=media&token=d2db1cb6-e543-414e-8964-e08a28e59a54"
            }
            if (filename == "motivation_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_4_full.jpg?alt=media&token=02af8e4a-a78e-4f99-9d9a-022fc0ea2c4e"
            }
            if (filename == "motivation_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_5_full.jpg?alt=media&token=6caf1cc1-8b07-48cc-9024-aaaa4587d089"
            }
            if (filename == "motivation_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_6_full.jpg?alt=media&token=1c83743c-139e-4749-b52f-ec5ba9cb603f"
            }
            if (filename == "motivation_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_7_full.jpg?alt=media&token=06523abf-44a7-4b9c-9164-80be8edbedae"
            }
            if (filename == "motivation_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_8_full.jpg?alt=media&token=996dd084-7c24-4523-ac00-846d3155ccc7"
            }
            if (filename == "motivation_9"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_9_full.jpg?alt=media&token=1ec08f62-144e-48b0-ae4b-42ebeb06d104"
            }
            if (filename == "motivation_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_10_full.jpg?alt=media&token=5fb2e450-12ba-4852-8b46-1bdf2d968d30"
            }
            if (filename == "motivation_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_11_full.jpg?alt=media&token=496abd5a-2709-4890-9a60-02f9e09b14ce"
            }
            if (filename == "motivation_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_12_full.jpg?alt=media&token=d268b344-12ee-4091-8ded-77c6ee94a9dd"
            }
            if (filename == "motivation_13"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_13_full.jpg?alt=media&token=6ff58aae-10a9-4752-96ba-aec86efe34dd"
            }
            if (filename == "motivation_14"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_14_full.jpg?alt=media&token=04b7804e-523e-42e6-91d5-0d90d356d142"
            }
            if (filename == "motivation_15"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_15_full.jpg?alt=media&token=15eb5d18-a890-40c6-863d-9a83d0ad1b74"
            }
            if (filename == "motivation_16"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_16_full.jpg?alt=media&token=2be0a27f-545b-498d-9747-9786ef6b3e92"
            }
            if (filename == "motivation_17"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_17_full.jpg?alt=media&token=1c4d45cf-4615-432d-9fde-1d3ef820101f"
            }
            if (filename == "motivation_18"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/motivation%2Fmotivation_18_full.jpg?alt=media&token=d32c38af-5cfc-4ebd-85e2-8424ff17c7aa"
            }
            if (filename == "music_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_1_full.jpg?alt=media&token=5c4c2c3e-7f5b-4a8c-84a6-c1c360233d61"
            }
            if (filename == "music_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_2_full.jpg?alt=media&token=802dba42-6130-4d85-bf99-af623efeb5df"
            }
            if (filename == "music_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_3_full.jpg?alt=media&token=5594a898-4a69-45fe-9217-eba5a5d2810f"
            }
            if (filename == "music_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_4_full.jpg?alt=media&token=c7608d99-4c26-4a9c-a2e0-b8dc679f4558"
            }
            if (filename == "music_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_5_full.jpg?alt=media&token=80049810-8c6f-43ed-ac3d-4d05ff11f4f7"
            }
            if (filename == "music_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_6_full.jpg?alt=media&token=f9ad1aae-0178-4e63-8882-790dc5dd7b2b"
            }
            if (filename == "music_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_7_full.jpg?alt=media&token=e6499972-900e-4eaf-8baa-328e36c063b0"
            }
            if (filename == "music_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_8_full.jpg?alt=media&token=02324d8b-5c9d-4aab-aa6c-6166ed7cc5c1"
            }
            if (filename == "music_9"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_9_full.jpg?alt=media&token=06202e3e-e8ea-4848-b23b-5026b2565001"
            }
            if (filename == "music_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_10_full.jpg?alt=media&token=4d7cf7f8-0bb0-416d-bd7b-62b668470388"
            }
            if (filename == "music_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_11_full.jpg?alt=media&token=3e6a4b34-5d42-4c6f-9872-2da843936d02"
            }
            if (filename == "music_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_12_full.jpg?alt=media&token=8d75a142-a362-45b3-959a-eac1e3dbe787"
            }
            if (filename == "music_13"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_13_full.jpg?alt=media&token=c955740d-f768-405a-9e55-bbf2eac42807"
            }
            if (filename == "music_14"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_14_full.jpg?alt=media&token=477e5955-8e32-47b9-a318-32f45c337031"
            }
            if (filename == "music_15"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_15_full.jpg?alt=media&token=962895df-bf65-438e-a881-3fce96b6333c"
            }
            if (filename == "music_17"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/music%2Fmusic_17_full.jpg?alt=media&token=6d708af9-f980-4722-9516-9e25329d4d3e"
            }
            if (filename == "nature_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_1_full.jpg?alt=media&token=cd5610cb-fcf2-485c-acfd-488d785ff45b"
            }
            if (filename == "nature_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_2_full.jpg?alt=media&token=8acd4a14-b8eb-49c3-aaf2-1aad4c68e0df"
            }
            if (filename == "nature_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_3_full.jpg?alt=media&token=b66d05c5-b5b7-4f87-92e5-4f0017eaa289"
            }
            if (filename == "nature_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_4_full.jpg?alt=media&token=996f31b1-334f-46a6-aef4-306332f696cc"
            }
            if (filename == "nature_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_5_full.jpg?alt=media&token=bdaabb07-6255-4d12-9c7d-2d7e9fb2f07b"
            }
            if (filename == "nature_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_6_full.jpg?alt=media&token=80433844-5636-4f18-aefb-5eb16db28986"
            }
            if (filename == "nature_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_7_full.jpg?alt=media&token=45b6c219-d505-48cf-af70-f9923d6d63db"
            }
            if (filename == "nature_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_8_full.jpg?alt=media&token=eee8af4a-a4cb-43dc-9bc3-6406b3266be2"
            }
            if (filename == "nature_9"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_9_full.jpg?alt=media&token=41723131-1afc-4bc3-8728-fac417262d66"
            }
            if (filename == "nature_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_10_full.jpg?alt=media&token=1d6f14d2-e2e3-4c41-acee-ca40e0b200d3"
            }
            if (filename == "nature_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_11_full.jpg?alt=media&token=d3408a88-9dc2-4aa1-baaf-95a019d0a3a5"
            }
            if (filename == "nature_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/nature%2Fnature_12_full.jpg?alt=media&token=9fecb5b1-1d4a-4858-be71-4b3dc69f79cb"
            }
            if (filename == "tech_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_1_full.jpg?alt=media&token=67f85ac1-020b-4c0d-802b-6e63068cd63b"
            }
            if (filename == "tech_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_2_full.jpg?alt=media&token=efb48deb-878b-4ef9-88e1-c2b0fdd6a16f"
            }
            if (filename == "tech_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_3_full.jpg?alt=media&token=99cd268c-3471-4be3-bb32-e824f3865a0a"
            }
            if (filename == "tech_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_4_full.jpg?alt=media&token=3423f981-cfbe-466f-88e0-5e267b117795"
            }
            if (filename == "tech_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_5_full.jpg?alt=media&token=7227d251-b3aa-444c-afe0-81612ce78001"
            }
            if (filename == "tech_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_6_full.jpg?alt=media&token=80ef7bd9-3384-4619-86dc-798a303f70ad"
            }
            if (filename == "tech_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_7_full.jpg?alt=media&token=c98762ad-b098-4727-8229-5aeb8f8ab650"
            }
            if (filename == "tech_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_8_full.jpg?alt=media&token=ba222b8c-0feb-416f-b90b-88dbf193dabd"
            }
            if (filename == "tech_9"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_9_full.jpg?alt=media&token=ca892d99-fbf9-47aa-8a9f-54ac1d2a5665"
            }
            if (filename == "tech_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_10_full.jpg?alt=media&token=e8c92c43-8fa1-4373-ae80-7aa9b4e0c8ad"
            }
            if (filename == "tech_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_11_full.jpg?alt=media&token=57681e06-6486-46bc-9d06-10f6e14672df"
            }
            if (filename == "tech_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/technology%2Ftech_12_full.jpg?alt=media&token=330afc52-15ea-4256-b210-ae1f724c1486"
            }
            if (filename == "trending_1"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_1_full.jpg?alt=media&token=7f7a651a-9d26-4f4e-bd3d-b8ffdb9d259f"
            }
            if (filename == "trending_2"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_2_full.jpg?alt=media&token=22562c3f-04e8-4229-9578-329631ad42df"
            }
            if (filename == "trending_3"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_3_full.jpg?alt=media&token=0c88a84e-b05e-4f87-a90f-bcc8f9aa3c4f"
            }
            if (filename == "trending_4"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_4_full.jpg?alt=media&token=48f73149-25bf-421b-bef5-df6e94715705"
            }
            if (filename == "trending_5"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_5_full.jpg?alt=media&token=03c44b3d-e9f6-4a75-9ead-84dfeb0c7418"
            }
            if (filename == "trending_6"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_6_full.jpg?alt=media&token=30bffcd7-c906-46e6-9bf6-8e94abdb4822"
            }
            if (filename == "trending_7"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_7_full.jpg?alt=media&token=a98230ba-1ec8-4560-83a3-6d569989e8ec"
            }
            if (filename == "trending_8"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_8_full.jpg?alt=media&token=6bdf1526-ec43-4fab-8e21-f02f3b7f970d"
            }
            if (filename == "trending_10"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_10_full.jpg?alt=media&token=67d5c4dd-564d-472c-897a-1985c76f23f3"
            }
            if (filename == "trending_11"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_11_full.jpg?alt=media&token=a16413cc-6955-408a-9d0d-db8da3fd6e86"
            }
            if (filename == "trending_12"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_12_full.jpg?alt=media&token=ca50b3d2-fc35-4164-870f-8a6f311c0f3b"
            }
            if (filename == "trending_13"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_13_full.jpg?alt=media&token=e8dc354f-9933-4ce0-983c-0eab553dbb44"
            }
            if (filename == "trending_14"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_14_full.jpg?alt=media&token=78d6aaec-2494-41ad-b1a4-a2b824121d14"
            }
            if (filename == "trending_15"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_15_full.jpg?alt=media&token=b2ae5cb4-4f58-4dad-9bd0-28b38471a557"
            }
            if (filename == "trending_16"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_16_full.jpg?alt=media&token=8deaf4b0-b417-4eaa-a059-bfaa31a89932"
            }
            if (filename == "trending_17"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_17_full.jpg?alt=media&token=78fc39a9-dc04-4a86-8bd4-2a7242433524"
            }
            if (filename == "trending_18"){
                return "https://firebasestorage.googleapis.com/v0/b/hdwallpapers-267c9.appspot.com/o/trending%2Ftrending_18_full.jpg?alt=media&token=91217866-deea-4ad2-b8ee-52f08011ccf3"
            }
            return ""
        }
    }

}