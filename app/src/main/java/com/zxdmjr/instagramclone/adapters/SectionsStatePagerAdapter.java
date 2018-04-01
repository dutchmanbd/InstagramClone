package com.zxdmjr.instagramclone.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "SectionsStatePagerAdapt";

    private List<Fragment> fragmentList = new ArrayList<>();
    private Map<Fragment, Integer> mapFragments = new HashMap<>();
    private Map<String, Integer> mapFragmentNumbers = new HashMap<>();
    private Map<Integer, String> mapFragmentNames = new HashMap<>();


    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String tag){

        fragmentList.add(fragment);
        mapFragments.put(fragment, fragmentList.size()-1);
        mapFragmentNumbers.put(tag, fragmentList.size()-1);
        mapFragmentNames.put(fragmentList.size()-1, tag);
    }

    /**
     * return the fragment with the tag param
     * @param tag
     * @return
     */
    public Integer getFragmentNumber(String tag){

        if(mapFragmentNumbers.containsKey(tag))
            return mapFragmentNumbers.get(tag);
        return null;

    }

    /**
     * return the fragment with the tag param
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment){

        if(mapFragments.containsKey(fragment))
            return mapFragments.get(fragment);
        return null;

    }

    /**
     * return the fragment with the tag param
     * @param fragmentNumber
     * @return
     */
    public String getFragmentName(String fragmentNumber){

        if(mapFragmentNames.containsKey(fragmentNumber))
            return mapFragmentNames.get(fragmentNumber);
        return null;

    }


}
