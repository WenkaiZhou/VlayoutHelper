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

import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;

/**
 * ClickableAdapter
 *
 * @author zhouwenkai@baidu.com ,Created on 2017-04-10 00:14:50
 *         Major Function：<b>Add click listener to Base Adapter</b>
 *         <p/>
 *         note:If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */

public abstract class ClickableAdapter<LH extends LayoutHelper> extends BaseAdapter<LH> {

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {

        // If the item can click
        if (clickable(position)) {
            holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onChildClick(v, position);
                }
            });
        }

        // If the item can long click
        if (longClickable(position)) {
            holder.getBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return onChildLongClick(v, position);
                }
            });
        }

        super.onBindViewHolder(holder, position);
    }

    /**
     * Whether the adapter item can click
     *
     * @param position
     * @return
     */
    protected boolean clickable(int position) {
        return true;
    }

    /**
     * Whether the adapter item can long click
     *
     * @param position
     * @return
     */
    protected boolean longClickable(int position) {
        return true;
    }

    /**
     * Called when a item view has been clicked.
     *
     * @param view
     * @param position
     */
    public void onChildClick(View view, int position) {
        // do nothing
    }

    /**
     * Called when a item view has been clicked and held.
     *
     * @param view
     * @param position
     * @return
     */
    public boolean onChildLongClick(View view, int position) {
        // do nothing
        return false;
    }

}
