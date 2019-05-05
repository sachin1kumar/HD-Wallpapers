package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import java.text.FieldPosition


class SeeAllAdapter(listOfdata: List<String>,context: Context)
    : RecyclerView.Adapter<SeeAllAdapter.ViewHolder>(){

    private var listOfimages = listOfdata
    private var context = context
    private var idcounter: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): SeeAllAdapter.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return SeeAllAdapter.ViewHolder(inflater.inflate(R.layout.see_all_rows, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return listOfimages.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position : Int) {
        idcounter++
        viewHolder.image.setImageURI(Uri.parse(listOfimages[position]))
        setOnClick(viewHolder.image,idcounter.toString(),listOfimages[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
    }

    private fun setOnClick(image: SimpleDraweeView,id:String,uri:String) {
        image.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                var imageFragment = ImageFragment()
                imageFragment.sharedElementEnterTransition = DetailsTransition()
                imageFragment.enterTransition = Fade()
                imageFragment.exitTransition = Fade()
                imageFragment.sharedElementReturnTransition = DetailsTransition()


                var bundle= Bundle()
                bundle.putString("uri",uri)

                imageFragment.arguments=bundle

                (context as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .addSharedElement(image,id)
                    .replace(R.id.see_all_constraintLayout, imageFragment)
                    .addToBackStack(null)
                    .commit()
            }

            Toast.makeText(MyApplication.instance.applicationContext,"Please wait..", Toast.LENGTH_SHORT).show()
        }
    }

}