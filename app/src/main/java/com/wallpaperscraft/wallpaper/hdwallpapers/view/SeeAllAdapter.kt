package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.net.Uri
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import java.text.FieldPosition


class SeeAllAdapter(listOfdata: List<String>)
    : RecyclerView.Adapter<SeeAllAdapter.ViewHolder>(){

    private var listOfimages = listOfdata

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): SeeAllAdapter.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return SeeAllAdapter.ViewHolder(inflater.inflate(R.layout.see_all_rows, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return listOfimages.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position : Int) {
        viewHolder.image.setImageURI(Uri.parse(listOfimages[position]))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
    }

}