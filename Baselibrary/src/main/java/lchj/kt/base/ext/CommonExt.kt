package lchj.kotlin.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.kotlin.base.rx.BaseFunc
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.utils.GlideUtils
import com.trello.rxlifecycle.LifecycleProvider
import lchj.kotlin.base.data.protocol.BaseResp
import lchj.kotlin.base.widgets.DefaultTextWatcher
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Kotlin通用扩展
 * name:lchj
 */

/**
 *   扩展Observable执行
 */
fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
//            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}

/**
 *   扩展数据转换
 */
fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

/**
 *  扩展Boolean类型数据转换
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{

    return this.flatMap(BaseFuncBoolean())
}
/**
 *  ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}


/**
 *   扩展Button可用性
 */
fun Button.enable(et: EditText, method: () -> Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/**
 * 扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}
/**
 *扩展点击事件，参数为方法
 */
fun View.onClick(method:() -> Unit):View{
    setOnClickListener { method() }
    return this
}

