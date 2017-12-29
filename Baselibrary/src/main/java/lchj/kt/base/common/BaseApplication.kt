package lchj.kotlin.base.common

import android.app.Application
import android.content.Context

/**
 * Created by XiMiTwo on 2017/12/14.
 */
open class BaseApplication : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        //ARouter初始化
//        ARouter.openLog()    // 打印日志
//        ARouter.openDebug()
//        ARouter.init(this)
    }

    /*
        Application Component初始化
     */
    private fun initAppInjection() {
//        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    /*
        全局伴生对象
     */
    companion object {
        lateinit var context: Context
    }
}