package com.zxdmjr.instagramclone.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.zxdmjr.instagramclone.constants.Constant;

public class UniversalImageLoader {

    private Context context;

    public UniversalImageLoader(Context context){
        this.context = context;
    }

    public ImageLoaderConfiguration getConfig(){

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                                        .showImageOnLoading(Constant.DEFAULT_IMAGE)
                                        .showImageForEmptyUri(Constant.DEFAULT_IMAGE)
                                        .showImageOnFail(Constant.DEFAULT_IMAGE)
                                        .cacheOnDisk(true).cacheInMemory(true)
                                        .cacheOnDisk(true).resetViewBeforeLoading(true)
                                        .imageScaleType(ImageScaleType.EXACTLY)
                                        .displayer(new FadeInBitmapDisplayer(300))
                                        .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                                                    .defaultDisplayImageOptions(options)
                                                    .memoryCache(new WeakMemoryCache())
                                                    .diskCacheSize(100*1024*1024)
                                                    .build();


        return configuration;

    }

    /**
     * this method can be used to set images that are static. It can't be used if the images
     * are being changed in the Fragment/Activity -OR if they are being set in a List or Grid
     * @param imgUrl
     * @param ivContainer
     * @param progressBar
     * @param append
     */
    public static void setImage(String imgUrl, ImageView ivContainer, final ProgressBar progressBar, String append){

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(append+imgUrl, ivContainer, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

                if(progressBar != null){
                    progressBar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(progressBar != null){
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(progressBar != null){
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(progressBar != null){
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

}
