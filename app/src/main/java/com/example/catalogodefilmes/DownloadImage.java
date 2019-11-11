package com.example.catalogodefilmes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

// Trecho de código obtido a partir da seguinte fonte: https://medium.com/@crossphd/android-image-loading-from-a-string-url-6c8290b82c5e
public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImage(ImageView bmImage){
        this.bmImage = (ImageView) bmImage;
    }

    protected Bitmap doInBackground(String... urls){
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try{
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        }catch(Exception e){
            Log.d("Error", e.getStackTrace().toString());
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result){
        bmImage.setImageBitmap(result);
    }
}
