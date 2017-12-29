package lchj.kt.user.presenter

import android.util.Log
import com.kotlin.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import lchj.kotlin.base.ext.excute
import lchj.kotlin.base.presenter.BasePresenter
import lchj.kotlin.user.presenter.view.RegisterView
import lchj.kotlin.user.service.impl.UserServiceimpl


/**
 * Created by XiMiTwo on 2017/12/13.
 */
class RegisterPresenter: BasePresenter<RegisterView>() {
    /**
     * 注册
     */
    fun register(phone:String,pwd:String,code:String){
        /**
         * 业务逻辑
         */
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        val userService = UserServiceimpl()
        userService.register(phone,pwd,code)
                .excute(object : BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
//                        mView.onRegisterResult(t)
                        if(t)
                            mView.onRegisterResult("注册成功")
                    }
                })
    }
}