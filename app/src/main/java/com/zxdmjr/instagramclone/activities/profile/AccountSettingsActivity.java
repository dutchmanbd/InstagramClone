package com.zxdmjr.instagramclone.activities.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.adapters.SectionsStatePagerAdapter;
import com.zxdmjr.instagramclone.utils.BottomNavigationViewHelper;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountSettingsActivity extends AppCompatActivity{

    private static final String TAG = "AccountSettingsActivity";
    private static final int ACTIVITY_NUM = 4;

    @BindView(R.id.lv_account_settings)
    ListView lvAccountSettings;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.rel_layout1)
    RelativeLayout relLayout;

    @BindView(R.id.bottom_nav_view_bar)
    BottomNavigationViewEx bottomNavigationViewEx;

    private SectionsStatePagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        ButterKnife.bind(this);

        setupSettingList();

        setupFragments();

        setupBottomNavigationView();

    }

    private void setupFragments() {

        adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment));       //fragment 0
        adapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment));               //fragment 1
    }

    private void setViewPager(int fragmentNumber){
        relLayout.setVisibility(View.GONE);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(fragmentNumber);

    }

    @OnClick(R.id.iv_back_arrow)
    void onBackPress(){
        finish();
    }

    private void setupSettingList() {

        List<String> options = Arrays.asList(getString(R.string.edit_profile_fragment), getString(R.string.sign_out_fragment));  //fragment 0,1

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options);
        lvAccountSettings.setAdapter(adapter);

        lvAccountSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setViewPager(position);
            }
        });

    }

    private void setupBottomNavigationView() {
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(AccountSettingsActivity.this, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
