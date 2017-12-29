package lchj.kotlin.user.service.impl

import lchj.kotlin.base.ext.convert
import lchj.kotlin.base.ext.convertBoolean
import lchj.kotlin.user.data.repository.UserRepository
import lchj.kotlin.user.service.UserService
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.data.protocol.UserInfo
import rx.Observable

/**
 * Created by XiMiTwo on 2017/12/13.
 * UserService实现类
 */
class UserServiceimpl:UserService {
    private val repository = UserRepository()

    override fun register(phone: String, pwd: String, code: String): Observable<Boolean> {
        return repository.register(phone, pwd, code).convertBoolean()
//        return repository.register(phone,pwd,code)
//                .flatMap(object : Func1<BaseResp<BaseToken>, Observable<Boolean>> {
//                    override fun call(t: BaseResp<BaseToken>): Observable<Boolean> {
//                        Log.e("111111","T:"+t);
//        {"status":1,"message":"ok","data":{"token":"31e15ff050c24791d789e12a2bf022f4306b0ed7"}}
        //返回的data为对象，需要用对象去接收
//                        if(t.status != 1 ){
//                            return Observable.error(BaseException(t.status,t.message))
//                        }
//                        return Observable.just(true)
//                    }
//                })

    }
    /**
     * 登录
     */
    override fun login(phone: String, password: String, pushId: String): Observable<BaseToken> {
        return repository.login(phone, password, pushId).convert()
    }
    /**
     * 修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}

