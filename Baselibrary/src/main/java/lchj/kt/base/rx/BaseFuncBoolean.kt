package com.kotlin.base.rx

import android.util.Log
import lchj.kotlin.base.data.protocol.BaseResp
import lchj.kt.base.common.ResultCode
import rx.Observable
import rx.functions.Func1

/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T>: Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        Log.e("3333333333","cccccccc"+t.status.toString())
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status, t.message))
        }

        return Observable.just(true)
    }
}
