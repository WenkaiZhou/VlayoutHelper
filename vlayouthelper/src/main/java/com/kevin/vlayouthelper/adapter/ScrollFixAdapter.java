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
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

/**
 * ScrollFixAdapter
 *
 * @author zhouwenkai@baidu.com ,Created on 2017-05-01 14:15:33
 *         Major Function：<b>Absolute layout which only shows after scrolling to its' position,used for FloatLayoutHelper</b>
 *
 *         note:If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */

public abstract class ScrollFixAdapter<T> extends FixAreaAdapter<ScrollFixLayoutHelper> {

    private int mAlignType = FixLayoutHelper.TOP_LEFT;
    private int mX = 0;
    private int mY = 0;

    protected T mData;

    public ScrollFixAdapter(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public ScrollFixAdapter(int alignType, int x, int y) {
        this(x, y);
        this.mAlignType = alignType;
    }

    @Override
    public ScrollFixLayoutHelper getLayoutHelper() {
        return new ScrollFixLayoutHelper(mAlignType, mX, mY);
    }

}
