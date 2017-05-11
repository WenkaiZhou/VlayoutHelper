/*
 * MIT License
 *
 * Copyright (c) 2017 Kevin zhou
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.kevin.vlayouthelper.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

/**
 * base Adapter for vlayout
 *
 * @author zwenkai@foxmail.com
 * @date 2017-04-09 18:47:22
 */

public abstract class BaseAdapter<LH extends LayoutHelper> extends DelegateAdapter.Adapter<BaseAdapter.BindingHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LH layoutHelper = getLayoutHelper();
        configLayoutHelper(layoutHelper);
        return layoutHelper;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getLayoutRes(),
                parent,
                false);
        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        setVariable(holder.getBinding(), position);
        holder.getBinding().executePendingBindings();
    }

    /**
     * 获取布局文件
     *
     * @return
     */
    public abstract int getLayoutRes();

    /**
     * 获取LayoutHelper
     *
     * @return
     */
    public abstract LH getLayoutHelper();

    /**
     * 配置LayoutHelper
     *
     * @param layoutHelper
     */
    public void configLayoutHelper(LH layoutHelper) {

    }

    /**
     * 设置变量数据
     * 比如：
     * binding.setVariable(BR.model, mAdvertise);
     * binding.setVariable(BR.handler, mHandler);
     *
     * @param binding
     * @param position
     */
    public abstract void setVariable(ViewDataBinding binding, int position);

    /**
     * BindingHolder
     */
    static class BindingHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

    }

}