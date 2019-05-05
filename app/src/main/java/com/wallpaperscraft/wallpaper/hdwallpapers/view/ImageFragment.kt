package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.app.WallpaperManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import java.lang.Exception
import java.util.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "uri"

class ImageFragment : Fragment() {
    private var uri: String? = null
    private var image: SimpleDraweeView? = null
    @get:JvmName("getContext_")
    private lateinit var view: View
    private var filename: String? = null
    private lateinit var close: TextView
    private lateinit var setwallpaper: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uri = it.getString(ARG_PARAM1)
            Log.e("ImageFragment", "uri:$uri")
            filename = getFileName(uri)
            Log.e("ImageFragment", "uri:filename:${filename.toString()}")

        }
    }

    private fun getFileName(uri: String?): String? {

        var ch = StringBuffer()
        for (index in 9..uri!!.length){

            if (uri[index] == '.'){
                break
            }

            ch.append(uri[index])

        }

        return ch.toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view= inflater.inflate(R.layout.fragment_image, container, false)
        image = view!!.findViewById(R.id.image)
        close = view!!.findViewById(R.id.close)
        setwallpaper = view!!.findViewById(R.id.set)
        showOptions()
        setClickListeners()
        // Inflate the layout for this fragment
        image!!.setImageURI("asset:///"+filename+"_full.jpg")

        view.setOnTouchListener { v, event ->
            // ignore all touch events
            true
        }

        return view
    }

    private fun setClickListeners() {
        close.setOnClickListener{
            activity!!.supportFragmentManager.popBackStack()
        }

        setwallpaper.setOnClickListener {
            try {
                WallpaperManager.getInstance(context)
                    .setStream(context!!.assets.open(filename+"_full.jpg"))
                Toast.makeText(MyApplication.instance.applicationContext,"Wallpaper changed!", Toast.LENGTH_SHORT).show()
                activity!!.supportFragmentManager.popBackStack()
            }catch (e:Exception){
                e.printStackTrace()
            }

        }
    }

    private fun showOptions() {
        try {
            val timerObj = Timer()
            val timerTaskObj = object : TimerTask() {
                override fun run() {
                    close.handler?.post {
                        close.visibility = View.VISIBLE
                    }
                    setwallpaper.handler?.post {
                        setwallpaper.visibility = View.VISIBLE
                    }
                }
            }
            timerObj.schedule(timerTaskObj, 5000)
        }catch (e:Exception){

        }
    }


}
