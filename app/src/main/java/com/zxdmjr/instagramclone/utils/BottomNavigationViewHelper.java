package com.zxdmjr.instagramclone.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.activities.home.HomeActivity;
import com.zxdmjr.instagramclone.activities.like.LikeActivity;
import com.zxdmjr.instagramclone.activities.profile.ProfileActivity;
import com.zxdmjr.instagramclone.activities.search.SearchActivity;
import com.zxdmjr.instagramclone.activities.share.ShareActivity;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";
    
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: setup bottom navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx view){

        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.nav_home:                 //ACTIVITY_NUM 0
                        Intent intent1 = new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        callingActivity.finish();
                        break;

                    case R.id.nav_search:               //ACTIVITY_NUM 1
                        Intent intent2 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        callingActivity.finish();

                        break;
                    case R.id.nav_share:                //ACTIVITY_NUM 2
                        Intent intent3 = new Intent(context, ShareActivity.class);
                        context.startActivity(intent3);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        callingActivity.finish();
                        break;
                    case R.id.nav_like:                 //ACTIVITY_NUM 3
                        Intent intent4 = new Intent(context, LikeActivity.class);
                        context.startActivity(intent4);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        callingActivity.finish();
                        break;
                    case R.id.nav_profile:              //ACTIVITY_NUM 4
                        Intent intent5 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent5);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        callingActivity.finish();
                        break;


                }

                return false;
            }
        });

    }
}
