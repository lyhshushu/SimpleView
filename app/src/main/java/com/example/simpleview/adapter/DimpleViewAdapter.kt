package com.example.simpleview.adapter

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.simpleview.simpleview.DimpleView

/**
 * Project Name: SimpleView
 * File Name:    DimpleViewAdapter.java
 * ClassName:    DimpleViewAdapter
 *
 * Description: view annotation adapter
 *
 * @author  yh.liu
 * @date    2020年10月20日 14:57
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
class DimpleViewAdapter {

    companion object {
        @BindingAdapter(value = ["isdimple"], requireAll = false)
        @JvmStatic
        public fun dimple(dimpleView: DimpleView, isDimpleView: Boolean?) {
            if (isDimpleView != null && isDimpleView) {
                dimpleView.setSendDimple()
            }
        }

        @BindingAdapter(value = ["image_animation"], requireAll = false)
        @JvmStatic
        public fun setAnimation(imageView: ImageView, boolean: Boolean) {
            if (boolean) {
                var animation = ObjectAnimator.ofFloat(imageView, View.ROTATION, 0f, 360f)
                animation.duration = 6000
                animation.repeatCount = -1
                animation.interpolator = LinearInterpolator()
                animation.start()
            }
        }

    }

}