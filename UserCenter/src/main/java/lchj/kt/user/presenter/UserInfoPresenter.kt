package lchj.kt.user.presenter

import com.kotlin.base.rx.BaseSubscriber
import lchj.kotlin.base.ext.excute
import lchj.kotlin.base.presenter.BasePresenter
import lchj.kotlin.user.presenter.view.RegisterView
import lchj.kotlin.user.service.impl.UserServiceimpl
import lchj.kt.user.data.protocol.UserInfo
import lchj.kt.user.presenter.view.UserInfoView

/**
 * Created by XiMiTwo on 2017/12/13.
 */
class UserInfoPresenter : BasePresenter<UserInfoView>() {
    /**
     * 用户
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        val userService = UserServiceimpl()
        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        })
    }
}