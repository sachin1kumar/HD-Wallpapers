package com.wallpaperscraft.wallpaper.hdwallpapers.model;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;
import com.wallpaperscraft.wallpaper.hdwallpapers.MyApplication;

import java.io.File;
import java.io.IOException;

public class SetWallpaper extends AsyncTask<Void,Void,Void> {

    private String filename;
    private ProgressDialog progressDialog;
    private BroadcastReceiver onDownloadComplete;

    public SetWallpaper(String filename, ProgressDialog progressDialog, BroadcastReceiver onDownloadComplete){
        this.filename = filename;
        this.progressDialog = progressDialog;
        this.onDownloadComplete = onDownloadComplete;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        File file = new File(Environment.getExternalStorageDirectory().getPath(),"/HDwallpapers/"+filename);

        Bitmap myBitmap =  BitmapFactory.decodeFile(file.getAbsolutePath());

        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(MyApplication.instance.getApplicationContext());
            wallpaperManager.setBitmap(myBitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyApplication.instance.getApplicationContext().unregisterReceiver(onDownloadComplete);
        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.dismiss();
        Toast.makeText(MyApplication.instance.getApplicationContext(), "Wallpaper changed!", Toast.LENGTH_SHORT)
                .show();
    }
}
