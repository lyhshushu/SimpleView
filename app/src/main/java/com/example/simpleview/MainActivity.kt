package com.example.simpleview

import android.util.Log
import com.example.simpleview.viewmodel.DimpleViewModel
import com.example.simpleview.viewmodel.MainActivityViewModel
import com.kunminx.architecture.ui.page.DataBindingActivity
import com.kunminx.architecture.ui.page.DataBindingConfig

class MainActivity : DataBindingActivity() {

    private lateinit var dimpleViewModel: DimpleViewModel
    private lateinit var mainViewModel: MainActivityViewModel

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_main, BR.vm, mainViewModel)
            .addBindingParam(BR.vmview, dimpleViewModel)
            .addBindingParam(BR.click, ClickProxy())
    }

    override fun initViewModel() {
        mainViewModel = getActivityViewModel(MainActivityViewModel::class.java)
        dimpleViewModel = appViewModelProvider.get(DimpleViewModel::class.java)
    }

    inner class ClickProxy {
        public fun dimpleClick() {
            dimpleViewModel.sendDimple.postValue(true)
            if (mainViewModel.backDrawableId.value == R.drawable.zhou) {
                mainViewModel.backDrawableId.value = R.drawable.ic_music1
            } else {
                mainViewModel.backDrawableId.value = R.drawable.zhou
            }
        }
    }
}