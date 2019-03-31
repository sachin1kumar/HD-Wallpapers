package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.hdwallpapers.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "uri"

class ImageFragment : Fragment() {
    private var uri: String? = null
    private var image: SimpleDraweeView? = null
    @get:JvmName("getContext_")
    private lateinit var view: View
    private var filename: String? = null

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view= inflater.inflate(R.layout.fragment_image, container, false)
        image = view!!.findViewById(R.id.image)
        // Inflate the layout for this fragment
        image!!.setImageURI("asset:///"+filename+"_full.webp")
        return view
    }


}
