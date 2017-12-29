package lchj.kt.user.presenter.view

import lchj.kotlin.base.presenter.view.BaseView
import lchj.kt.user.data.protocol.UserInfo

/**
 * Created by XiMiTwo on 2017/12/13.
 */
interface UserInfoView : BaseView {
    /**
     * 获取上传凭证回调
     */

    fun onGetUploadTokenResult(result:String)

    /**
     *   编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}