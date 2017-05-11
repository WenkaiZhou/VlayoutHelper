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

import com.alibaba.android.vlayout.layout.FixLayoutHelper;

/**
 * LayoutHelper that will be located as fix position,used for FixLayoutHelper
 *
 * @author zwenkai@foxmail.com
 * @date 2017-05-01 13:57:40
 * @since 1.0.0
 */

public abstract class FixAdapter<T> extends FixAreaAdapter<FixLayoutHelper> {

    private int mAlignType = FixLayoutHelper.TOP_LEFT;
    private int mX = 0;
    private int mY = 0;

    protected T mData;

    public FixAdapter(int x, int y) {
        this(FixLayoutHelper.TOP_LEFT, x, y);
    }

    public FixAdapter(int alignType, int x, int y) {
        this(null, alignType, x, y);
    }

    public FixAdapter(T data, int x, int y) {
        this(data, FixLayoutHelper.TOP_LEFT, x, y);
    }

    public FixAdapter(T data, int alignType, int x, int y) {
        this.mData = data;
        this.mAlignType = alignType;
        this.mX = x;
        this.mY = y;
    }

    @Override
    public FixLayoutHelper getLayoutHelper() {
        return new FixLayoutHelper(mAlignType, mX, mY);
    }

}
