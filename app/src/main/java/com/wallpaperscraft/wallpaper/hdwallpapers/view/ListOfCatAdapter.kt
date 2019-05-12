package com.wallpaperscraft.wallpaper.hdwallpapers.view

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
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication
import com.wallpaperscraft.wallpaper.hdwallpapers.R


class ListOfCatAdapter(listOfDashData:HashMap<String,List<String> >,context:FragmentActivity)
    : RecyclerView.Adapter<ListOfCatAdapter.ViewHolder>() {

    private var listOfdata = listOfDashData
    private lateinit var listOfimages: List<String>
    private lateinit var category: String
    private var context=context

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
            0 -> category = MyApplication.instance.getString(R.string.text_cat_first)
            1 -> category = MyApplication.instance.getString(R.string.text_cat_second)
            2 -> category = MyApplication.instance.getString(R.string.text_cat_third)
            3 -> category = MyApplication.instance.getString(R.string.text_cat_fourth)
            4 -> category = MyApplication.instance.getString(R.string.text_cat_fifth)
            5 -> category = MyApplication.instance.getString(R.string.text_cat_sixth)
            6 -> category = MyApplication.instance.getString(R.string.text_cat_seventh)
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


        setOnClick(viewHolder.image1,"1",listOfimages[0])
        setOnClick(viewHolder.image2,"2",listOfimages[1])
        setOnClick(viewHolder.image3,"3",listOfimages[2])
        setOnClick(viewHolder.image4,"4",listOfimages[3])
        setOnClick(viewHolder.image5,"5",listOfimages[4])
        setOnClick(viewHolder.image6,"6",listOfimages[5])
        setOnClick(viewHolder.image7,"7",listOfimages[6])
        setOnClick(viewHolder.image8,"8",listOfimages[7])


        viewHolder.category.text = category
        viewHolder.seeall.setTag(category)

        setOnClickSeeall(viewHolder.seeall)
    }

    private fun setOnClickSeeall(seeall: TextView) {
        seeall.setOnClickListener {
            //TODO
            var seeallfrag = SeeAllFragment(context)
            seeallfrag.setData(seeall)
            context.supportFragmentManager
                .beginTransaction()
                .replace(R.id.constraintLayout, seeallfrag)
                .addToBackStack(null)
                .commit()
        }
    }


    private fun setOnClick(image: SimpleDraweeView,id:String,uri:String) {
         image.setOnClickListener {

             if (MyApplication().isNetworkConnected()) {
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                     var imageFragment = ImageFragment()
                     imageFragment.sharedElementEnterTransition = DetailsTransition()
                     imageFragment.enterTransition = Fade()
                     imageFragment.exitTransition = Fade()
                     imageFragment.sharedElementReturnTransition = DetailsTransition()


                     var bundle = Bundle()
                     bundle.putString("uri", uri)

                     imageFragment.arguments = bundle

                     context.supportFragmentManager
                         .beginTransaction()
                         .addSharedElement(image, id)
                         .replace(R.id.constraintLayout, imageFragment)
                         .addToBackStack(null)
                         .commit()
                 }
             }
             else {
                 Toast.makeText(MyApplication.instance.applicationContext,"No internet connection",Toast.LENGTH_SHORT).show()
             }
        }
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
        var seeall: TextView = itemView.findViewById(R.id.seeall)
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