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

import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelperEx;

import java.util.List;

/**
 * <pre>
 * Currently support 1+6(max) layout
 *
 * Created by J!nl!n on 2017/3/7.
 *
 * 1 + 4
 * -------------------------
 * |       |       |       |
 * |       |   2   |   3   |
 * |       |       |       |
 * |   1   |-------|-------|
 * |       |       |       |
 * |       |   4   |   5   |
 * |       |       |       |
 * -------------------------
 *
 *  1 + 5
 * -------------------------
 * |           |     2     |
 * |     1     |-----------|
 * |           |     3     |
 * -------------------------
 * |       |       |       |
 * |   4   |   5   |   6   |
 * |       |       |       |
 * -------------------------
 *
 *  1 + 6
 * -------------------------
 * |       |   2   |   3   |
 * |       |-------|-------|
 * |   1   |   4   |   5   |
 * |       |-------|-------|
 * |       |   6   |   7   |
 * -------------------------
 * </pre>
 *
 * @author zwenkai@foxmail.com
 * @date Created on 2017-04-10 02:47:15
 * @since 1.0.2
 */

public abstract class OnePlusAdapterEx<T> extends ClickableAdapter<OnePlusNLayoutHelperEx> {

    private int mItemCount = 0;

    protected List<T> mItems;

    public OnePlusAdapterEx() {
    }

    public OnePlusAdapterEx(int itemCount) {
        this.mItemCount = itemCount;
    }

    public OnePlusAdapterEx(List<T> items) {
        this.mItems = items;
        this.mItemCount = items.size();
    }

    @Override
    public OnePlusNLayoutHelperEx getLayoutHelper() {
        return new OnePlusNLayoutHelperEx(mItemCount);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType();
    }

    /**
     * get ViewType
     * If the ViewType is same，please use getViewType rather than getViewType.
     *
     * @return
     */
    public int getViewType() {
        return 0;
    }

}
