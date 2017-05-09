package com.kevin.vlayouthelper.sample.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/**
 * Created by zhouwenkai on 2017/5/9.
 */

public class HomeFragment extends Fragment {

    HomeFragmentBinding mBinding;

    private HomeViewModel mHomeViewModel;

    public HomeFragment() {
        // Requires empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public void setViewModel(HomeViewModel viewModel) {
        mHomeViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = HomeFragmentBinding.inflate(inflater, container, false);
        mBinding.setView(this);
        mBinding.setViewmodel(mHomeViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecyclerAdapter();
    }

    private void setupRecyclerAdapter() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        mBinding.recyclerView.setLayoutManager(layoutManager);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mBinding.recyclerView.setAdapter(delegateAdapter);
    }


    @Override
    public void onResume() {
        super.onResume();

        mHomeViewModel.start();
    }
}
