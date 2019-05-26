package com.wallpaperscraft.wallpaper.hdwallpapers.model;


import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadSaveFile extends AsyncTask<Void, Void, Void> {

    public static File file;
    InputStream is;
    private String filename, url, filepath;
    private long downloadID;
    private ProgressDialog progressDialog;
    private Context context;
    private Activity activity;

    public DownloadSaveFile(String filename, String url, Context context, Activity activity) {
        this.filename = filename;
        this.url = url;
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Setting wallpaper..");
        MyApplication.instance.getApplicationContext().registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    protected Void doInBackground(Void... voids) {
        File direct = new File(Environment.getExternalStorageDirectory()
                + "/HDwallpapers");

        if (!direct.exists()) {
            direct.mkdirs();
        }

        DownloadManager mgr = (DownloadManager) MyApplication.instance.getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

        Uri downloadUri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(
                downloadUri);

        request.setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false).setTitle("Demo")
                .setDescription("Something useful. No, really.")
                .setDestinationInExternalPublicDir("/HDwallpapers", filename);

        downloadID =  mgr.enqueue(request);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

    }

    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                new SetWallpaper(filename,progressDialog,onDownloadComplete).execute();
            }
        }
    };
}

