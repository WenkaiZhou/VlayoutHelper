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
package com.kevin.vlayouthelper.adapter;

import com.alibaba.android.vlayout.LayoutHelper;
import com.kevin.vlayouthelper.animation.AnimationLoader;
import com.kevin.vlayouthelper.animation.BaseAnimation;

/**
 * Animation Adapter
 *
 * @author zwenkai@foxmail.com
 * @date 2018-01-25 10:17:41
 * @since 1.0.0
 */

public abstract class AnimationAdapter<LH extends LayoutHelper> extends BaseAdapter<LH> {

    protected AnimationLoader animationLoader = new AnimationLoader();

    @Override
    public void onViewAttachedToWindow(BindingHolder holder) {
        super.onViewAttachedToWindow(holder);
        animationLoader.startAnimation(holder);
    }

    /**
     * 启动加载动画
     *
     * @param animation BaseAnimation
     */
    public void enableAnimation(BaseAnimation animation) {
        animationLoader.enableLoadAnimation(animation, true);
    }

    /**
     * 启动加载动画
     *
     * @param animation               BaseAnimation
     * @param isShowAnimWhenFirstLoad boolean 是否只有在第一次展示的时候才使用动画
     */
    public void enableAnimation(BaseAnimation animation, boolean isShowAnimWhenFirstLoad) {
        animationLoader.enableLoadAnimation(animation, isShowAnimWhenFirstLoad);
    }

}
