package lchj.kotlin.base.presenter.view

/**
 * Created by XiMiTwo on 2017/12/13.
 */
interface BaseView {
    /**
     * 显示对话框的方法
     */
    fun showLoading()
    /**
     * 隐藏对话框的方法
     */
    fun hideLoading()
    /**
     * 错误的方法
     */
    fun onError(text:String)
}