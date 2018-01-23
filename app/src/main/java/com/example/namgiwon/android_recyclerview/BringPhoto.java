package com.example.namgiwon.android_recyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by namgiwon on 2017. 12. 5..
 */

public class BringPhoto extends AsyncTask<Void,Void,Bitmap>{
    Bitmap bmImg;
    String path;
    Bitmap resized;
    ImageView imageView = null;
 public BringPhoto(String path, ImageView imageView){
     this.imageView = imageView;
     this.path = path;
 }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        try{
            URL imageUrl = new URL(path);
            Log.d("asdf",path);
            HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;

            InputStream is = conn.getInputStream();
            bmImg = BitmapFactory.decodeStream(is,null,options);
            resized = Bitmap.createScaledBitmap( bmImg, 1024,1024, true );

//            bmImg = BitmapFactory.decodeStream(is);
            Log.d("aaaaa",bmImg.toString());

        }catch(IOException e){
            e.printStackTrace();
        }
        return resized;
    }

    protected void onPostExecute(Bitmap img){
        imageView.setImageBitmap(img);
    }



}

