package com.kevin.vlayouthelper.sample.adapter;

import android.databinding.ViewDataBinding;

import com.kevin.loopview.internal.LoopData;
import com.kevin.vlayouthelper.adapter.SingleAdapter;
import com.kevin.vlayouthelper.adapter.StickyAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.HomeIndex;
import com.kevin.vlayouthelper.sample.R;

/**
 * Created by zhouwenkai on 2017/5/2.
 */

public class RecommendTitleAdapter extends StickyAdapter<HomeIndex.RecommendTitle> {

    public RecommendTitleAdapter(HomeIndex.RecommendTitle data) {
        this.mData = data;
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
    public void setVariable(ViewDataBinding binding, int position) {
        binding.setVariable(BR.model, mData);
    }
}
