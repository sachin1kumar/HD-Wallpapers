package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.wallpaperscraft.wallpaper.images.model.ImagesURI
import com.facebook.imagepipeline.request.ImageRequest



class ListOfCatAdapter(listOfDashData: Pair<List<String>,List<String>>)
    : RecyclerView.Adapter<ListOfCatAdapter.ViewHolder>() {

    private var listOfCategoriesUri: List<String> = listOfDashData.first
    private var listOfCategoriesNames: List<String> = listOfDashData.second

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(inflater.inflate(R.layout.category_rows, viewGroup, false))
    }

    override fun getItemCount():Int {
       return listOfCategoriesUri.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        resizeDashImages(Uri.parse(listOfCategoriesUri.get(position)),viewHolder.image)
        viewHolder.image.setImageURI(Uri.parse(listOfCategoriesUri.get(position)))
        viewHolder.category.text = listOfCategoriesNames.get(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.myImageView)
        var category: TextView = itemView.findViewById(R.id.myImageViewText)
    }


    fun resizeDashImages(uri: Uri,mSimpleDraweeView:SimpleDraweeView){
        val request = ImageRequestBuilder.newBuilderWithSource(uri)
            .setResizeOptions(ResizeOptions(20, 10))
            .build()
        mSimpleDraweeView.controller = Fresco.newDraweeControllerBuilder()
            .setOldController(mSimpleDraweeView.getController())
            .setImageRequest(request)
            .build()
    }

}