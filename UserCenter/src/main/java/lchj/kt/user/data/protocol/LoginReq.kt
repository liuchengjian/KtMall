package lchj.kt.user.data.protocol

/**
 * 登录请求体
 */
data class LoginReq(val phone:String, val password:String, val pushId:String)