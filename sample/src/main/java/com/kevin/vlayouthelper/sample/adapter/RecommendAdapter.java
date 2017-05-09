package com.kevin.vlayouthelper.sample.adapter;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.kevin.vlayouthelper.adapter.GridAdapter;
import com.kevin.vlayouthelper.adapter.StaggeredGridAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.HomeIndex;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.databinding.LayoutBannerAdapterBinding;
import com.kevin.vlayouthelper.sample.databinding.LayoutRecommendAdapterBinding;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/1.
 */

public class RecommendAdapter extends StaggeredGridAdapter<HomeIndex.Recommend> {

    public RecommendAdapter(List<HomeIndex.Recommend> items, int lanes) {
        super(lanes, 0);
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
        ((LayoutRecommendAdapterBinding) binding).main.getLayoutParams().height = mItems.get(position).height * 5;
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_RECOMMEND;
    }

}
