package com.zxdmjr.instagramclone.activities.like;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.activities.home.HomeActivity;
import com.zxdmjr.instagramclone.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LikeActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 3;

    @BindView(R.id.bottom_nav_view_bar)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        ButterKnife.bind(this);

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView() {
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(LikeActivity.this,this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
