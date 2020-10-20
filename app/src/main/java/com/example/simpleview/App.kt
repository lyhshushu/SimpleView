package com.example.simpleview

import com.kunminx.architecture.BaseApplication

/**
 * Project Name: SimpleView
 * File Name:    App.java
 * ClassName:    App
 *
 * Description: BaseApplication
 *
 * @author  yh.liu
 * @date    2020年10月20日 13:58
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
class App : BaseApplication() {
    //TODO tip：可借助 Application 来管理一个应用级 的 SharedViewModel，
    // 实现全应用范围内的 生命周期安全 且 事件源可追溯的 视图控制器 事件通知。
    override fun onCreate() {
        super.onCreate()
    }
}