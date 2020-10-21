package com.example.simpleview.adapter

import android.animation.ObjectAnimator
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.simpleview.simpleview.DimpleView
import com.zhouwei.blurlibrary.EasyBlur

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

        @BindingAdapter(value = ["image_circle"], requireAll = false)
        @JvmStatic
        public fun setCircleImage(imageView: ImageView, drawable: Int) {
            Glide.with(imageView.context).load(drawable).circleCrop().into(imageView)
        }

        @BindingAdapter(value = ["blur_back"], requireAll = false)
        @JvmStatic
        public fun setBlurBack(layout: ConstraintLayout, drawable: Int) {
            layout.background = BitmapDrawable(
                EasyBlur.with(layout.context).bitmap(
                    ResourcesCompat.getDrawable(
                        layout.context.resources,
                        drawable,
                        null
                    )?.toBitmap(100,100,null)
                ).radius(10).blur()
            )
        }


        @BindingAdapter(value = ["image_animation"], requireAll = false)
        @JvmStatic
        public fun setAnimation(imageView: ImageView, boolean: Boolean) {
            if (boolean) {
                var animation = ObjectAnimator.ofFloat(imageView, View.ROTATION, 0f, 360f)
                animation.duration = 10000
                animation.repeatCount = -1
                animation.interpolator = LinearInterpolator()
                animation.start()
            }
        }

    }

}