package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;

import com.kevin.vlayouthelper.adapter.StickyAdapter;
import com.kevin.vlayouthelper.animation.AlphaInAnimation;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;

/**
 * Created by zhouwenkai on 2017/5/2.
 */

public class RecommendTitleAdapter extends StickyAdapter<HomeIndex.RecommendTitle> {

    public RecommendTitleAdapter(HomeIndex.RecommendTitle data) {
        super(data);
        enableAnimation(new AlphaInAnimation());
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_RECOMMEND_TITLE;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_recommend_title_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding) {
        binding.setVariable(BR.model, mData);
    }
}
