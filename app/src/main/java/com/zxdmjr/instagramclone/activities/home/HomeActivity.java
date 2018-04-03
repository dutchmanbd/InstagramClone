package com.zxdmjr.instagramclone.activities.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.adapters.SectionsPagerAdapter;
import com.zxdmjr.instagramclone.utils.BottomNavigationViewHelper;
import com.zxdmjr.instagramclone.utils.UniversalImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 0;

    @BindView(R.id.bottom_nav_view_bar)
    BottomNavigationViewEx bottomNavigationViewEx;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initImageLoader();

        ButterKnife.bind(this);

        setupBottomNavigationView();
        setupViewPager();
    }

    private void initImageLoader(){
        UniversalImageLoader loader = new UniversalImageLoader(HomeActivity.this);
        ImageLoader.getInstance().init(loader.getConfig());
    }


    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessageFragment());

        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabs.getTabAt(1).setIcon(R.drawable.ic_instagram);
        tabs.getTabAt(2).setIcon(R.drawable.ic_send);

    }

    private void setupBottomNavigationView() {
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(HomeActivity.this,this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
