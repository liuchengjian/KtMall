package lchj.kotlin.base.presenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import lchj.kotlin.base.common.BaseApplication
import lchj.kotlin.base.presenter.view.BaseView

/**
 * Created by XiMiTwo on 2017/12/13.
 */
open class BasePresenter<T:BaseView> {
    /**
     * lateinit延迟加载var变量
     */
    lateinit var mView:T
    var context = BaseApplication.context
    /**
     * 检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}