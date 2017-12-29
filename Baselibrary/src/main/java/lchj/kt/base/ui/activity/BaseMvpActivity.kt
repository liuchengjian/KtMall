package lchj.kotlin.base.ui.activity

import android.content.Context
import android.os.Bundle
import lchj.kotlin.base.presenter.BasePresenter
import lchj.kotlin.base.presenter.view.BaseView
import lchj.kt.base.widgets.ProgressLoading
import org.jetbrains.anko.toast


/**
 * Created by XiMiTwo on 2017/12/13.
 */
open class BaseMvpActivity <T:BasePresenter<*>>:BaseActivity(),BaseView {

    private lateinit var mLoadingDialog:ProgressLoading
    private lateinit var mContext:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 初始加载框
         */
        mLoadingDialog = ProgressLoading.create(this)
        mContext = this
    }
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /**
     * 错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }

    lateinit var mPresenter:T
}