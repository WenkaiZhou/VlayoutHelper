package com.kevin.vlayouthelper.sample.home.adapter;

import android.databinding.ViewDataBinding;

import com.kevin.vlayouthelper.adapter.SingleAdapter;
import com.kevin.vlayouthelper.sample.BR;
import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.home.HomeIndex;
import com.kevin.vlayouthelper.sample.home.HomeViewModel;

/**
 * Created by zhouwenkai on 2017/5/23.
 */

public class BroadcastAdapter extends SingleAdapter<HomeIndex.Broadcast> {

    public BroadcastAdapter(HomeViewModel viewModel, HomeIndex.Broadcast broadcast) {
        super(broadcast);
    }

    @Override
    public int getViewType() {
        return HomeViewType.VIEW_TYPE_BROADCAST;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_broadcast_adapter;
    }

    @Override
    public void setVariable(ViewDataBinding binding) {
        binding.setVariable(BR.model, mData);
    }
}
