package lchj.kotlin.user.data.repository

import android.util.Log
import lchj.kotlin.base.data.net.RetrofitFactory
import lchj.kotlin.base.data.protocol.BaseResp
import lchj.kotlin.user.data.api.UserApi
import lchj.kotlin.user.data.protocol.RegisterReq
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.EditUserReq
import lchj.kt.user.data.protocol.LoginReq
import lchj.kt.user.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * 用户相关数据层、网络层
 *
 */
class UserRepository {
    /**
     * 用户注册
     */
    fun register(phone:String,pwd:String,code:String):Observable<BaseResp<BaseToken>>{
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(phone, pwd, code))
    }
    /**
     *登录
     */
    fun login(mobile:String,pwd:String,pushId:String): Observable<BaseResp<BaseToken>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile,pwd,pushId))
    }
    /**
     *  编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).editUser(EditUserReq(userIcon,userName,userGender,userSign))
    }

}