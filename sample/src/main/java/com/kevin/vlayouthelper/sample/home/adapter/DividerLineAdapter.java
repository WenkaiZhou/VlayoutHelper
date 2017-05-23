package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;

import com.android.databinding.library.baseAdapters.BR;
import com.kevin.vlayouthelper.adapter.SingleAdapter;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;

/**
 * Created by zhouwenkai on 2017/5/23.
 */

public class DividerLineAdapter extends SingleAdapter<HomeIndex.DividerLine> {

    public DividerLineAdapter(HomeIndex.DividerLine dividerLine) {
        super(dividerLine);
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_DIVIDER_LINE;
    }

    @Override
    public void setVariable(ViewDataBinding binding) {
        binding.setVariable(BR.model, mData);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_divider_line_adapter;
    }
}
