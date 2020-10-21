package com.example.simpleview.viewmodel

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.simpleview.R
import com.kunminx.architecture.ui.callback.UnPeekLiveData

/**
 * Project Name: SimpleView
 * File Name:    MainActivityViewModel.java
 * ClassName:    MainActivityViewModel
 *
 * Description: ActivityViewModel
 *
 * @author  yh.liu
 * @date    2020年10月20日 11:42
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
class MainActivityViewModel : ViewModel() {

    var backDrawableId = UnPeekLiveData<Int>()

    init {
        this.backDrawableId.value = R.drawable.zhou
    }
}