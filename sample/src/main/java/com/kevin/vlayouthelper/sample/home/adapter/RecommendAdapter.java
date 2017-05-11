package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.kevin.vlayouthelper.adapter.StaggeredGridAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/1.
 */

public class RecommendAdapter extends StaggeredGridAdapter<HomeIndex.Recommend> {

    public RecommendAdapter(List<HomeIndex.Recommend> items, int lanes) {
        super(lanes);
        this.mItems = items;
    }

    @Override
    public void onChildClick(View view, int position) {
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_recommend_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        binding.setVariable(BR.model, mItems.get(position));
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_RECOMMEND;
    }

}
