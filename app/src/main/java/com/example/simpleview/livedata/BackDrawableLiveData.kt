package com.example.simpleview.livedata

import androidx.lifecycle.LiveData
import com.kunminx.architecture.ui.callback.UnPeekLiveData

/**
 * Project Name: SimpleView
 * File Name:    BackDrawableLiveData.java
 * ClassName:    BackDrawableLiveData
 *
 * Description: livedata
 *
 * @author  yh.liu
 * @date    2020年10月21日 14:04
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
class BackDrawableLiveData<T> : LiveData<T>() {

    private var insideData: Any? = null

    public override fun setValue(value: T) {
        super.setValue(value)
        insideData = value
    }

    public override fun postValue(value: T) {
        super.postValue(value)
        insideData = value
    }

    public override fun getValue(): T {
        return (insideData as T)
    }
}