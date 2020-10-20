package com.example.simpleview

import com.example.simpleview.viewmodel.DimpleViewModel
import com.example.simpleview.viewmodel.MainActivityViewModel
import com.kunminx.architecture.ui.page.DataBindingActivity
import com.kunminx.architecture.ui.page.DataBindingConfig

class MainActivity : DataBindingActivity() {

    private var dimpleViewModel = DimpleViewModel()
    private var mainViewModel = MainActivityViewModel()

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
        }
    }


}