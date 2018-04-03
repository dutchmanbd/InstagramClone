package com.zxdmjr.instagramclone.activities.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zxdmjr.instagramclone.R;
import com.zxdmjr.instagramclone.utils.UniversalImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    @BindView(R.id.civ_edit_profile_pic)
    CircleImageView civProfileImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        ButterKnife.bind(this, view);

        setProfileImage();

        return view;
    }

    @OnClick(R.id.iv_back_arrow)
    void onBackPress(){
        getActivity().finish();
    }



    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: set profile image");

        String imgUrl = "www.image.flaticon.com/icons/svg/702/702023.svg";
        //String imgUrl = "st2.depositphotos.com/1006318/5909/v/950/depositphotos_59095529-stock-illustration-profile-icon-male-avatar.jpg";

        UniversalImageLoader.setImage(imgUrl, civProfileImage, null, "https://");
    }
}
