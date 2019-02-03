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



class ListOfCatAdapter(listOfDashData:HashMap<String,List<String> >)
    : RecyclerView.Adapter<ListOfCatAdapter.ViewHolder>() {

    private var listOfdata = listOfDashData
    private lateinit var listOfimages: List<String>
    private lateinit var category: String

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(inflater.inflate(R.layout.category_rows, viewGroup, false))
    }

    override fun getItemCount():Int {
       return listOfdata.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //resizeDashImages(Uri.parse(listOfCategoriesUri.get(position)),viewHolder.image)

        when (position) {
            0 -> category = "trending"
            1 -> category = "abstract"
            2 -> category = "nature"
            3 -> category = "music"
            4 -> category = "vehicle"
            5 -> category = "tech"
            6 -> category = "animal"
        }

        listOfimages = listOfdata[category]!!
        viewHolder.image1.setImageURI(Uri.parse(listOfimages[0]))
        viewHolder.image2.setImageURI(Uri.parse(listOfimages[1]))
        viewHolder.image3.setImageURI(Uri.parse(listOfimages[2]))
        viewHolder.image4.setImageURI(Uri.parse(listOfimages[3]))
        viewHolder.image5.setImageURI(Uri.parse(listOfimages[4]))
        viewHolder.image6.setImageURI(Uri.parse(listOfimages[5]))
        viewHolder.image7.setImageURI(Uri.parse(listOfimages[6]))
        viewHolder.image8.setImageURI(Uri.parse(listOfimages[7]))

        viewHolder.category.text = category
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image1: SimpleDraweeView = itemView.findViewById(R.id.image_first)
        var image2: SimpleDraweeView = itemView.findViewById(R.id.image_second)
        var image3: SimpleDraweeView = itemView.findViewById(R.id.image_third)
        var image4: SimpleDraweeView = itemView.findViewById(R.id.image_fourth)
        var image5: SimpleDraweeView = itemView.findViewById(R.id.image_fifth)
        var image6: SimpleDraweeView = itemView.findViewById(R.id.image_sixth)
        var image7: SimpleDraweeView = itemView.findViewById(R.id.image_seventh)
        var image8: SimpleDraweeView = itemView.findViewById(R.id.image_eigth)
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