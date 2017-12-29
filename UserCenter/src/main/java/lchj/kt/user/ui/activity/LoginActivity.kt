package lchj.kt.user.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import lchj.kotlin.base.ext.enable
import lchj.kotlin.base.ext.onClick
import lchj.kotlin.base.ui.activity.BaseMvpActivity
import lchj.kotlin.user.ui.activity.RegisterActivity
import lchj.kt.base.data.protocol.BaseToken
import lchj.kt.user.R
import lchj.kt.user.data.protocol.UserInfo
import lchj.kt.user.presenter.LoginPresenter
import lchj.kt.user.presenter.view.LoginView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginView ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        mPresenter = LoginPresenter()
        mPresenter.mView = this
    }

    /**
     *初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        mForgetPwdTv.onClick(this)
    }

    /**
     * 点击事件
     */
    override fun onClick(view: View) {
        when(view.id){
            R.id.mRightTv -> {startActivity<RegisterActivity>()}

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }
//            R.id.mForgetPwdTv ->{
//                startActivity<ForgetPwdActivity>()
//            }
        }
    }


    /**
     *  判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    /**
     * 回调，显示在界面
     */
    override fun onLoginResult(result: BaseToken) {
        toast("登录成功")
        Log.e("result","result:"+result)
        startActivity<UserInfoActivity>()
//        startActivity(intentFor<UserInfoActivity>("ipone" to mMobileEt.text.toString() ))
        UserPrefsUtils.putUserToken(result)
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE,mMobileEt.text.toString())
//        startActivity<UserInfoActivity>("phone" to mMobileEt.text.toString())
        finish()
    }


}
