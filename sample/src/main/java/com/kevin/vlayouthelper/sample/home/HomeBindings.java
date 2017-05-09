package com.kevin.vlayouthelper.sample.home;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/10.
 */
public class HomeBindings {

    @SuppressWarnings("unchecked")
    @BindingAdapter("adapters")
    public static void setItems(RecyclerView recyclerView, List<DelegateAdapter.Adapter> adapters) {
        DelegateAdapter adapter = (DelegateAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setAdapters(adapters);
        }
    }

}
