package com.wallpaperscraft.wallpaper.hdwallpapers.view

import android.app.Dialog
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.startapp.android.publish.ads.banner.Banner
import com.startapp.android.publish.adsCommon.StartAppSDK
import com.wallpaperscraft.wallpaper.hdwallpapers.R
import com.wallpaperscraft.wallpaper.images.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var catRecyclerView: RecyclerView
    private var listOfDashData: HashMap<String,List<String> >? = null
    private lateinit var toolbar: Toolbar
    private val SHARED_PREFS_GDPR_SHOWN = "gdpr_dialog_was_shown"
    private var banner: Banner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initStartAppSdkAccordingToConsent()

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ImageViewModel::class.java)

        catRecyclerView = findViewById(R.id.list)
        toolbar = findViewById(R.id.tool_bar)
        banner = findViewById(R.id.startAppBanner)
        banner!!.showBanner()

        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false)


        (viewModel as ImageViewModel).getDashboardData().observe(
            this, android.arch.lifecycle.Observer {
                listOfDashData = it!!
                var catAdapter = ListOfCatAdapter(listOfDashData!!,this)
                var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
                catRecyclerView.layoutManager = mLayoutManager
                catRecyclerView.itemAnimator
                catRecyclerView.isNestedScrollingEnabled = false
                catRecyclerView.setHasFixedSize(true)
                catRecyclerView.adapter = catAdapter
            })

    }

    private fun initStartAppSdkAccordingToConsent() {
        if (getPreferences(Context.MODE_PRIVATE).getBoolean(SHARED_PREFS_GDPR_SHOWN, false)) {
            initStartAppSdk()
        } else {
            showGdprDialog()
        }
    }

    private fun initStartAppSdk() {
        //Initialize start-app sdk
        //TODO
        StartAppSDK.init(this, "", false)
    }

    private fun showGdprDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_gdr, null)
        val dialog = Dialog(this, android.R.style.Theme_Light_NoTitleBar)
        dialog.setContentView(view)
        /*
        var medium: Typeface = Typeface.createFromAsset(getAssets(), "gotham_medium.ttf")
        var book: Typeface  = Typeface.createFromAsset(getAssets(), "gotham_book.ttf")*/

        val okBtn = view.findViewById<View>(R.id.okBtn)
        //okBtn.typeface = medium

        okBtn.setOnClickListener(View.OnClickListener {
            writePersonalizedAdsConsent(true)
            dialog.dismiss()
        })


        val cancelBtn = view.findViewById<View>(R.id.cancelBtn)
        //cancelBtn.typeface = medium

        cancelBtn.setOnClickListener(View.OnClickListener {
            writePersonalizedAdsConsent(false)
            dialog.dismiss()
        })

        dialog.show()
    }

    private fun writePersonalizedAdsConsent(userConsent: Boolean) {
        StartAppSDK.setUserConsent(
            this,
            "pas",
            System.currentTimeMillis(),
            userConsent
        )

        getPreferences(Context.MODE_PRIVATE)
            .edit()
            .putBoolean(SHARED_PREFS_GDPR_SHOWN, true)
            .commit()
    }

}
