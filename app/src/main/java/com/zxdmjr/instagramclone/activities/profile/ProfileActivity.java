package com.zxdmjr.instagramclone.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.activities.like.LikeActivity;
import com.zxdmjr.instagramclone.adapters.GridImageAdapter;
import com.zxdmjr.instagramclone.constants.Constant;
import com.zxdmjr.instagramclone.utils.BottomNavigationViewHelper;
import com.zxdmjr.instagramclone.utils.UniversalImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;

    @BindView(R.id.profile_toolbar)
    Toolbar toolbar;

    @BindView(R.id.pb_profile)
    ProgressBar pbProfile;

    @BindView(R.id.bottom_nav_view_bar)
    BottomNavigationViewEx bottomNavigationViewEx;

    @BindView(R.id.iv_profile_menu)
    ImageView ivProfileMenu;

    @BindView(R.id.civ_profile_image)
    CircleImageView civProfileImage;

    @BindView(R.id.gv_profile)
    GridView gvProfileImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setProfileImage();

        setupGridImages();

        pbProfile.setVisibility(View.GONE);

        setupBottomNavigationView();
    }

    private void setupGridImages() {

        List<String> imgURLs = new ArrayList<>();
        imgURLs.clear();

        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

//        imgUrls.add("https://cdn0.iconfinder.com/data/icons/social-messaging-ui-color-shapes/128/user-male-circle-blue-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo-32-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo-33-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo-28-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo3-22-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo-29-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo3-11-256.png");
//        imgUrls.add("https://cdn2.iconfinder.com/data/icons/flat-seo-web-ikooni/128/flat_seo3-12-256.png");
//        imgUrls.add("https://cdn4.iconfinder.com/data/icons/people-std-pack/512/social_network-256.png");
//        imgUrls.add("https://cdn3.iconfinder.com/data/icons/digital-marketing/512/user_business_person_businessman_man_flat_icon-256.png");

        setGridAdapter(imgURLs);

    }

    private void setGridAdapter(List<String> imgUrls) {

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth / Constant.NUM_OF_COLUMNS;

        gvProfileImages.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(ProfileActivity.this, R.layout.layout_grid_imageview, "", imgUrls);
        gvProfileImages.setAdapter(adapter);
    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: set profile image");
        String imgUrl = "www.image.flaticon.com/icons/svg/702/702023.svg";
        //String imgUrl = "st2.depositphotos.com/1006318/5909/v/950/depositphotos_59095529-stock-illustration-profile-icon-male-avatar.jpg";

        UniversalImageLoader.setImage(imgUrl, civProfileImage, null, "https://");
    }

    @OnClick(R.id.iv_profile_menu)
    void onChangeAccountSettings(){

        //Log.d(TAG, "onChangeAccountSettings: on profile menu clicked");
        Intent intent = new Intent(getApplicationContext(), AccountSettingsActivity.class);
        startActivity(intent);
    }

    private void setupBottomNavigationView() {
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
