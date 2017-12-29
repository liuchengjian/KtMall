package lchj.kt.user.presenter

import com.kotlin.base.rx.BaseSubscriber
import lchj.kotlin.base.ext.excute
import lchj.kotlin.base.presenter.BasePresenter
import lchj.kotlin.user.presenter.view.RegisterView
import lchj.kotlin.user.service.impl.UserServiceimpl
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.UserInfo
import lchj.kt.user.presenter.view.LoginView
import rx.Observable

/**
 * Created by XiMiTwo on 2017/12/13.
 */
class LoginPresenter : BasePresenter<LoginView>() {
    /**
     * 登录
     */
    fun login(phone:String,password:String,pushId:String) {
        /**
         * 业务逻辑
         */
        val userService = UserServiceimpl()
        userService.login(phone,password,pushId)
                .excute(object : BaseSubscriber<BaseToken>(mView){
                    override fun onNext(t: BaseToken) {
                        mView.onLoginResult(t)
                    }
                })
    }
}