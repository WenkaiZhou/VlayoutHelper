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

import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.List;

/**
 * LayoutHelper provides GridLayout,used for GridLayoutHelper
 *
 * -------------------------
 * |     |     |     |     |
 * |     |     |     |     |
 * -------------------------
 * |     |     |     |     |
 * |     |     |     |     |
 * -------------------------
 *
 * @author zwenkai@foxmail.com
 * @date 2017-05-01 00:58:51
 * @since 1.0.0
 */

public abstract class GridAdapter<T> extends ClickableAdapter<GridLayoutHelper> {

    protected List<T> mItems;
    protected int mSpanCount;

    public GridAdapter(int spanCount) {
        this.mSpanCount = spanCount;
    }

    public GridAdapter(List<T> items, int spanCount) {
        this(spanCount);
        this.mItems = items;
    }

    @Override
    public GridLayoutHelper getLayoutHelper() {
        return new GridLayoutHelper(mSpanCount);
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
