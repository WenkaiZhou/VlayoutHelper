package com.kevin.vlayouthelper.sample.adapter;

import android.databinding.ViewDataBinding;

import com.kevin.loopview.internal.LoopData;
import com.kevin.vlayouthelper.adapter.SingleAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;

/**
 * Created by zhouwenkai on 2017/5/2.
 */

public class BannerAdapter extends SingleAdapter<LoopData> {

    public BannerAdapter(LoopData loopData) {
        this.mData = loopData;
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_BANNER;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_banner_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        binding.setVariable(BR.model, mData);
    }
}
