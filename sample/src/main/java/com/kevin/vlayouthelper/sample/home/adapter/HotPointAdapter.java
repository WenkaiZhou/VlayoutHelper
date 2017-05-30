package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.kevin.vlayouthelper.adapter.GridAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;
import com.kevin.vlayouthelper.sample.home.HomeViewModel;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/1.
 */

public class HotPointAdapter extends GridAdapter<HomeIndex.HotPoint> {

    private HomeViewModel mViewModel;

    public HotPointAdapter(HomeViewModel viewModel, List<HomeIndex.HotPoint> items, int spanCount) {
        super(items, spanCount);
        this.mViewModel = viewModel;
    }

    @Override
    public void onChildClick(View view, int position) {
        mViewModel.onHotPointItemClick(view, mItems.get(position));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_hot_point_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        binding.setVariable(BR.model, mItems.get(position));
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_HOT_POINT;
    }

    @Override
    public void configLayoutHelper(GridLayoutHelper layoutHelper) {
        layoutHelper.setBgColor(Color.WHITE);
        layoutHelper.setAspectRatio(1 / mSpanCount);
    }
}
