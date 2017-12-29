package lchj.kt.user.presenter.view

import lchj.kotlin.base.presenter.view.BaseView
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.UserInfo

/**
 * Created by XiMiTwo on 2017/12/13.
 */
interface LoginView : BaseView {
    /**
     * 回调方法
     */
    fun onLoginResult(result: BaseToken)
}