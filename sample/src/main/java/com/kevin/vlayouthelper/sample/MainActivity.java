package com.kevin.vlayouthelper.sample;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.google.gson.Gson;
import com.kevin.vlayouthelper.AdapterBuild;
import com.kevin.vlayouthelper.sample.adapter.BannerAdapter;
import com.kevin.vlayouthelper.sample.adapter.HotPointAdapter;
import com.kevin.vlayouthelper.sample.utils.LocalFileUtils;

import java.util.List;

public class MainActivity extends Activity {

    MainActivityBinding mBinding;
    DelegateAdapter mDelegateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mDelegateAdapter = new DelegateAdapter(layoutManager, true);
        mBinding.recyclerView.setAdapter(mDelegateAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String homeIndexStr = LocalFileUtils.getStringFormAsset(this, "home_index.json");
        HomeIndex homeIndex = new Gson().fromJson(homeIndexStr, HomeIndex.class);

        List<DelegateAdapter.Adapter> mAdapters = new AdapterBuild()
                .registerAdapter(new BannerAdapter(homeIndex.loopData))
                .registerAdapter(new HotPointAdapter(homeIndex.hotPoint, 5))
                .build();
        mDelegateAdapter.setAdapters(mAdapters);
    }
}
