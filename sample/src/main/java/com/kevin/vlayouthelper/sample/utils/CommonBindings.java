package com.kevin.vlayouthelper.sample.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class CommonBindings {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(view);
    }

    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext()).load(url).error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(view);
    }

    @BindingAdapter("android:layout_width")
    public static void setLayoutWidth(View view, float dipValue) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp != null) {
            lp.width = DisplayUtils.dip2px(view.getContext(), dipValue);
            view.setLayoutParams(lp);
        }
    }

    @BindingAdapter("android:layout_height")
    public static void setLayoutHeight(View view, float dipValue) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp != null) {
            lp.height = DisplayUtils.dip2px(view.getContext(), dipValue);
            view.setLayoutParams(lp);
        }
    }

}