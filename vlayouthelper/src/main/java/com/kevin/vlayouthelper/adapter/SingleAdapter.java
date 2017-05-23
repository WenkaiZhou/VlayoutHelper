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

import android.databinding.ViewDataBinding;

import com.alibaba.android.vlayout.layout.SingleLayoutHelper;

/**
 * SingleAdapter
 *
 * -------------------------
 * |                       |
 * |                       |
 * |                       |
 * -------------------------
 *
 * @author zwenkai@foxmail.com
 * @date 2017-04-10 00:28:47
 * @since 1.0.0
 */

public abstract class SingleAdapter<T> extends ClickableAdapter<SingleLayoutHelper> {

    protected T mData;

    public SingleAdapter() {

    }

    public SingleAdapter(T data) {
        this.mData = data;
    }

    @Override
    public SingleLayoutHelper getLayoutHelper() {
        return new SingleLayoutHelper();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType();
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        setVariable(binding);
    }

    /**
     * get ViewType
     *
     * @return
     */
    public abstract int getViewType();

    /**
     * Set variable data
     *
     * example：
     * binding.setVariable(BR.model, mAdvertise);
     *
     * @param binding
     */
    public abstract void setVariable(ViewDataBinding binding);

}
