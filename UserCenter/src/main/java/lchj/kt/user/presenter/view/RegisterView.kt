package lchj.kotlin.user.presenter.view

import lchj.kotlin.base.presenter.view.BaseView

/**
 * Created by XiMiTwo on 2017/12/13.
 */
interface RegisterView: BaseView {
    /**
     * 回调方法
     */
//    fun onRegisterResult(result: Boolean)
    fun onRegisterResult(result:String)
}