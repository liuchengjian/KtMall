package lchj.kotlin.user.service

import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.UserInfo
import rx.Observable


/**
 * Created by XiMiTwo on 2017/12/13.
 */
interface UserService {
    /**
     * 注册
     */
    fun register(phone:String,pwd:String,code:String): Observable<Boolean>
    /**
     * 用户登录
     */
    fun login(phone:String,password:String,pushId:String):Observable<BaseToken>

    /**
     * 编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}