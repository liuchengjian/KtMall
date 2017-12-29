package lchj.kotlin.user.data.api

import lchj.kotlin.base.data.protocol.BaseResp
import lchj.kotlin.user.data.protocol.RegisterReq
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.EditUserReq
import lchj.kt.user.data.protocol.LoginReq
import lchj.kt.user.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by XiMiTwo on 2017/12/25.
 */
interface UserApi {
    /**
     * 注册
     */
    @POST("/index.php/api/v1/login")
    fun register(@Body req:RegisterReq):Observable<BaseResp<BaseToken>>

    /**
     * 登录
     */
    @POST("/index.php/api/v1/login")
    fun login(@Body req: LoginReq):Observable<BaseResp<BaseToken>>
    /**
     *  编辑用户资料
     */
    @POST("userCenter/editUser")
    fun editUser(@Body req: EditUserReq):Observable<BaseResp<UserInfo>>
}