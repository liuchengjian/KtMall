package com.kotlin.mall.common

import lchj.kotlin.base.common.BaseApplication

/*
    主工程 Application
 */
class MainApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
//        JPushInterface.setDebugMode(true)
//        JPushInterface.init(this)
    }
}


