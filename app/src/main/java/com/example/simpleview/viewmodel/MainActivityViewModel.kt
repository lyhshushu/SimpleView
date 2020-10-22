package com.example.simpleview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleview.R

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

    var backDrawableId = MutableLiveData<Int>()

    init {
        backDrawableId.value = R.drawable.zhou
    }
}