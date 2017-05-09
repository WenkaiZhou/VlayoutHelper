package com.kevin.vlayouthelper.sample.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.kevin.vlayouthelper.sample.R;
import com.kevin.vlayouthelper.sample.ViewModelHolder;
import com.kevin.vlayouthelper.sample.utils.ActivityUtils;

public class HomeActivity extends AppCompatActivity {

    HomeActivityBinding mBinding;

    HomeViewModel mViewModel;

    public static final String HOME_VIEWMODEL_TAG = "HOME_VIEWMODEL_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = HomeActivityBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        HomeFragment homeFragment = findOrCreateViewFragment();

        mViewModel = findOrCreateViewModel();
        // Link View and ViewModel
        homeFragment.setViewModel(mViewModel);

    }

    @NonNull
    private HomeFragment findOrCreateViewFragment() {
        HomeFragment tasksFragment =
                (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }
        return tasksFragment;
    }

    private HomeViewModel findOrCreateViewModel() {
        ViewModelHolder<HomeViewModel> retainedViewModel =
                (ViewModelHolder<HomeViewModel>) getSupportFragmentManager()
                        .findFragmentByTag(HOME_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            return retainedViewModel.getViewmodel();
        } else {
            HomeViewModel viewModel = new HomeViewModel(getApplicationContext());
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ViewModelHolder.createContainer(viewModel),
                    HOME_VIEWMODEL_TAG);
            return viewModel;
        }
    }

    @Override
    protected void onDestroy() {
        mViewModel.onActivityDestroyed();
        super.onDestroy();
    }

}
