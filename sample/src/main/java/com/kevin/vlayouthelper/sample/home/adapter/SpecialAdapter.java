package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.kevin.vlayouthelper.adapter.OnePlusAdapter;
import com.kevin.vlayouthelper.animation.SlideInRightAnimation;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;
import com.kevin.vlayouthelper.sample.home.HomeViewModel;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/30.
 */

public class SpecialAdapter extends OnePlusAdapter<HomeIndex.Special> {

    private HomeViewModel mViewModel;

    public SpecialAdapter(HomeViewModel viewModel, List<HomeIndex.Special> items) {
        super(items);
        this.mViewModel = viewModel;
        enableAnimation(new SlideInRightAnimation());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_special_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        binding.setVariable(BR.model, mItems.get(position));
    }

    @Override
    public void onChildClick(View view, int position) {
        mViewModel.onSpecialItemClick(view, mItems.get(position));
    }
}
