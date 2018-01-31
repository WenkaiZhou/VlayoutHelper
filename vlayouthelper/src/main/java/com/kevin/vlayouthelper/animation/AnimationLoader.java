/*
 * MIT License
 *
 * Copyright (c) 2018 Kevin zhou
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
package com.kevin.vlayouthelper.animation;

import android.support.annotation.NonNull;

import com.kevin.vlayouthelper.adapter.BaseAdapter;

/**
 * Animation Loader
 *
 * @author zwenkai@foxmail.com
 * @date 2018-01-25 09:45:00
 * @since 1.1.0
 */

public class AnimationLoader {
    protected int lastAnimIndex = -1;
    protected boolean isAnimEnable;
    protected boolean isShowAnimWhenFirst;
    protected BaseAnimation animation;

    /**
     * 打开加载动画
     *
     * @param animation               BaseAnimation
     * @param isShowAnimWhenFirstLoad 是否只有在第一次展示的时候才使用动画
     */
    public void enableLoadAnimation(@NonNull BaseAnimation animation, boolean isShowAnimWhenFirstLoad) {
        this.isAnimEnable = true;
        this.isShowAnimWhenFirst = isShowAnimWhenFirstLoad;
        this.animation = animation;
    }


    /**
     * 根据条件开启动画
     *
     * @param holder BaseViewHolder
     */
    public void startAnimation(@NonNull BaseAdapter.BindingHolder holder) {
        //如果动画开关关闭则返回
        if (!isAnimEnable) {
            return;
        }

        int adapterPosition = holder.getAdapterPosition();

        //判断是否初次展示的时候展示动画
        if (!isShowAnimWhenFirst || adapterPosition > lastAnimIndex) {

            if (null != animation) {
                animation.start(holder);
            }

            lastAnimIndex = holder.getAdapterPosition();
        }
    }

    public boolean isAnimEnable() {
        return isAnimEnable;
    }

    public void setAnimEnable(boolean animEnable) {
        isAnimEnable = animEnable;
    }

    public boolean isShowAnimWhenFirst() {
        return isShowAnimWhenFirst;
    }

    public void setShowAnimWhenFirst(boolean showAnimWhenFirst) {
        isShowAnimWhenFirst = showAnimWhenFirst;
    }

    public BaseAnimation getAnimation() {
        return animation;
    }

    public void setAnimation(@NonNull BaseAnimation animation) {
        this.animation = animation;
    }

    public void clear() {
        lastAnimIndex = -1;
    }

}
