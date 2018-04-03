package com.zxdmjr.instagramclone.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.utils.SquareImageView;

import java.util.List;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context context;
    private LayoutInflater inflater;
    private int resourceId;
    private String append;
    private List<String> imgUrls;

    public GridImageAdapter(@NonNull Context context, int resourceId, String append, @NonNull List<String> imgUrls) {
        super(context, resourceId, imgUrls);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.resourceId = resourceId;
        this.append = append;
        this.imgUrls = imgUrls;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*
           ViewHolder build pattern(Similar to recylerview)
         */
        final ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(resourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = (SquareImageView) convertView.findViewById(R.id.iv_grid_image);
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.pb_grid);

            convertView.setTag(holder);

        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        String imgUrl = getItem(position);

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(append + imgUrl, holder.imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(holder.progressBar != null){
                    holder.progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(holder.progressBar != null){
                    holder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(holder.progressBar != null){
                    holder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(holder.progressBar != null){
                    holder.progressBar.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }

    private static class ViewHolder{

        SquareImageView imageView;
        ProgressBar progressBar;
    }


}
