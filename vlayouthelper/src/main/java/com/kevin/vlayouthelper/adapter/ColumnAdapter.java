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

import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;

import java.util.List;

/**
 * Layout view in one line with the same of different cloumn width
 * <pre>
 * 1 column
 * -------------------------
 * |                       |
 * |                       |
 * |                       |
 * -------------------------
 *
 * 2 columns with same column width for each one
 * -------------------------
 * |           |           |
 * |           |           |
 * |           |           |
 * |           |           |
 * |           |           |
 * |           |           |
 * |           |           |
 * -------------------------
 *
 * 3 columns with different column widh for each one
 * -------------------------
 * |     |         |       |
 * |     |         |       |
 * |     |         |       |
 * |     |         |       |
 * |     |         |       |
 * |     |         |       |
 * |     |         |       |
 * -------------------------
 *
 * </pre>
 *
 * @author zwenkai@foxmail.com
 * @date Created on 2017-05-11 19:16:00
 * @since 1.0.2
 */

public abstract class ColumnAdapter<T> extends ClickableAdapter<ColumnLayoutHelper> {

    private float[] mWeights;

    protected List<T> mItems;

    public ColumnAdapter() {
    }

    public ColumnAdapter(float[] weights) {
        this(null, weights);
    }

    public ColumnAdapter(List<T> items) {
        this(items, null);
    }

    public ColumnAdapter(List<T> items, float[] weights) {
        this.mItems = items;
        this.mWeights = weights;
    }

    @Override
    public ColumnLayoutHelper getLayoutHelper() {
        ColumnLayoutHelper layoutHelper =  new ColumnLayoutHelper();
        layoutHelper.setWeights(mWeights);
        return layoutHelper;
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
