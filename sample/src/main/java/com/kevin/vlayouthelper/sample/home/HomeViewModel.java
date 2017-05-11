package com.kevin.vlayouthelper.sample.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.google.gson.Gson;
import com.kevin.vlayouthelper.AdapterBuild;
import com.kevin.vlayouthelper.sample.home.adapter.BannerAdapter;
import com.kevin.vlayouthelper.sample.home.adapter.HotPointAdapter;
import com.kevin.vlayouthelper.sample.home.adapter.RecommendAdapter;
import com.kevin.vlayouthelper.sample.home.adapter.RecommendTitleAdapter;
import com.kevin.vlayouthelper.sample.utils.LocalFileUtils;

import java.util.List;

/**
 * Created by zhouwenkai on 2017/5/9.
 */

public class HomeViewModel extends BaseObservable {

    // These observable fields will update Views automatically
    public final ObservableList<DelegateAdapter.Adapter> adapters = new ObservableArrayList<>();

    private Context mContext;
    private HomeIndex mHomeIndex;

    public HomeViewModel(Context context) {
        mContext = context.getApplicationContext();
    }

    public void start() {
        loadData();
    }

    private void loadData() {
        String homeIndexStr = LocalFileUtils.getStringFormAsset(mContext, "home_index.json");
        mHomeIndex = new Gson().fromJson(homeIndexStr, HomeIndex.class);

        List<DelegateAdapter.Adapter> mAdapters = new AdapterBuild()
                .addAdapter(new BannerAdapter(this, mHomeIndex.loopData))
                .addAdapter(new HotPointAdapter(this, mHomeIndex.hotPoint, 5))
                .addAdapter(new RecommendTitleAdapter(mHomeIndex.recommendTitle))
                .addAdapter(new RecommendAdapter(mHomeIndex.recommend, 2))
                .build();
        adapters.clear();
        adapters.addAll(mAdapters);
    }

    /**
     * Banner点击监听的方法
     *
     * @param parent
     * @param view
     * @param position
     * @param realPosition
     */
    public void onBannerItemClick(PagerAdapter parent, View view, int position, int realPosition) {
        Toast.makeText(mContext, "Clicked position " + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * HotPoint点击监听的方法
     *
     * @param view
     * @param position
     */
    public void onHotPointItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "go to " + mHomeIndex.hotPoint.get(position).name , Toast.LENGTH_SHORT).show();
    }

    public void onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
    }
}
