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

import com.alibaba.android.vlayout.layout.StickyLayoutHelper;

/**
 * LayoutHelper which allow item sticky to start/end, used for StickyLayoutHelper
 *
 * @author zwenkai@foxmail.com
 * @date 2017-05-01 14:08:04
 * @since 1.0.0
 */

public abstract class StickyAdapter<T> extends FixAreaAdapter<StickyLayoutHelper> {

    protected T mData;

    private boolean mStickyStart = true;

    public StickyAdapter() {
        this(true);
    }

    public StickyAdapter(boolean stickyStart) {
        this(null, stickyStart);
    }

    public StickyAdapter(T data) {
        this(data, true);
    }

    public StickyAdapter(T data, boolean stickyStart) {
        this.mData = data;
        this.mStickyStart = stickyStart;
    }

    @Override
    public StickyLayoutHelper getLayoutHelper() {
        return new StickyLayoutHelper(mStickyStart);
    }

    @Override
    public void setVariable(ViewDataBinding binding, int position) {
        setVariable(binding);
    }

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
