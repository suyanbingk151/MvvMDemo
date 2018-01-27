package com.mvvm.gionee.mvvmdemo.utils;

import android.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by sulc on 2018/1/18.
 */

public class BindingUtils {

    @BindingAdapter("image")
    public static void loadImage(SimpleDraweeView image, String uri){
        if(image!=null){
            image.setImageURI(uri);
        }
    }

    @BindingAdapter("image")
    public static void loadImage(SimpleDraweeView image, int id){
        if(image!=null){
            image.setImageResource(id);
        }
    }
}
