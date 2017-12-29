package lchj.kotlin.user.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*
import lchj.kotlin.base.ext.enable
import lchj.kotlin.base.ext.onClick
import lchj.kotlin.base.ui.activity.BaseMvpActivity
import lchj.kotlin.base.widgets.VerifyButton
import lchj.kotlin.user.presenter.view.RegisterView
import lchj.kt.user.R
import lchj.kt.user.presenter.RegisterPresenter
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView ,View.OnClickListener {

    override fun onRegisterResult(result: String) {
        toast(result)
        finish()
    }
//    override fun onRegisterResult(result: Boolean) {
//        toast("注册成功")
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        //实例化mPresenter
        mPresenter = RegisterPresenter()
        mPresenter.mView = this
//
    }
    private fun initView() {
        mRegisterBtn.enable(mMobileEt,{isBtnEnable()})//监听输入手机号的输入事件
        mRegisterBtn.enable(mVerifyCodeEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isBtnEnable()})

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
//        mVerifyCodeBtn.setOnClickListener(this)
    }
    /**
     * 点击事件
     */
    override fun onClick(view: View) {
        when(view.id){
            R.id.mVerifyCodeBtn ->{
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mRegisterBtn ->{
                mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
            }
        }
    }
    /**
     *  判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()&&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

}
