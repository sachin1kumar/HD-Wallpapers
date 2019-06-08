package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.app.WallpaperManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.wallpaperscraft.wallpaper.hdwallpapers.model.DownloadSaveFile
import com.wallpaperscraft.wallpaper.images.model.ImagesURI
import kotlinx.android.synthetic.main.category_rows.*
import kotlinx.coroutines.*
import java.io.File
import java.io.FileInputStream
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
    private lateinit var progressDialog: ProgressDialog
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(viewModelJob+Dispatchers.Main)
    private lateinit var source:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uri = it.getString(ARG_PARAM1)
            source = it.getString("source")
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

        progressDialog = ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
        uiScope.launch {
            progressDialog.show()
            progressDialog.setCancelable(false)
            progressDialog.setMessage("Loading wallpaper..")
            getImagefromserver()
            showOptions()
            progressDialog.dismiss()
            uiScope.cancel()
        }

        setClickListeners()

        // Inflate the layout for this fragment
        view.setOnTouchListener { v, event ->
            // ignore all touch events
            true
        }

        return view
    }

    private suspend fun getImagefromserver() {
        withContext(Dispatchers.Main){
            image!!.setImageURI(filename?.let { ImagesURI.getdisplayUrl(it) })
            delay(10000)
        }
    }

    private fun setClickListeners() {
        close.setOnClickListener{
            activity!!.supportFragmentManager.popBackStack()
        }

        setwallpaper.setOnClickListener {


            if (ContextCompat.checkSelfPermission(
                    MyApplication.instance.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    MyApplication.instance.applicationContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                if (source.equals("seeall",true)) {
                    /*ActivityCompat.requestPermissions(
                        SeeAllAdapter.fcontext as Activity,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        123
                    )*/
                    ActivityCompat.requestPermissions(
                        SeeAllAdapter.fcontext as Activity,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        123
                    )
                }
                else{
                    /*ActivityCompat.requestPermissions(
                        ListOfCatAdapter.fcontext as Activity,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        123
                    )*/
                    ActivityCompat.requestPermissions(
                        ListOfCatAdapter.fcontext as Activity,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        123
                    )
                }

            } else {

                try {
                    progressDialog.dismiss()
                    DownloadSaveFile(filename + "_full.jpg", ImagesURI.getdisplayUrl(filename!!),context,activity!!).execute()
                    activity!!.supportFragmentManager.popBackStack()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode==123){
            if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                try {
                    progressDialog.dismiss()
                    DownloadSaveFile(filename + "_full.jpg", ImagesURI.getdisplayUrl(filename!!),context,activity!!).execute()
                    /*  WallpaperManager.getInstance(context)
                          .setStream(context!!.assets.open(filename + "_full.jpg"))*/
                    // WallpaperManager.getInstance(context).setBitmap(loadImageBitmap(filename!!))

                    activity!!.supportFragmentManager.popBackStack()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            else{
                Toast.makeText(MyApplication.instance.applicationContext, "Need permission to set the wallpaper.", Toast.LENGTH_SHORT)
                    .show()
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
