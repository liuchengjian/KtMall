package com.kotlin.base.rx

import android.util.Log
import lchj.kotlin.base.data.protocol.BaseResp
import lchj.kt.base.common.ResultCode
import rx.Observable
import rx.functions.Func1

/*
    通用数据类型转换封装
 */
class BaseFunc<T>:Func1<BaseResp<T>,Observable<T>>{
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){

            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}
