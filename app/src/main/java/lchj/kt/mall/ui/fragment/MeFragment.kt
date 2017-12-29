package lchj.kt.mall.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.common.afterLogin
import com.kotlin.provider.common.isLogined
import kotlinx.android.synthetic.main.fragment_me.*
import lchj.kotlin.base.ext.loadUrl
import lchj.kotlin.base.ext.onClick
import lchj.kt.mall.R
import lchj.kt.mall.ui.activity.SettingActivity
import lchj.kt.user.ui.activity.LoginActivity
import lchj.kt.user.ui.activity.UserInfoActivity
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * Created by XiMiTwo on 2017/12/28.
 */
class MeFragment: BaseFragment() ,View.OnClickListener{


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun onStart() {
        super.onStart()
        //加载初始数据
        loadData()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)

        mWaitPayOrderTv.onClick(this)
        mWaitConfirmOrderTv.onClick(this)
        mCompleteOrderTv.onClick(this)
        mAllOrderTv.onClick(this)
        mAddressTv.onClick(this)
        mShareTv.onClick(this)
        mSettingTv.onClick(this)
    }

    /**
     * 加载初始数据
     */
    private fun loadData() {
        if(isLogined()){
            //如果登录了
            val userIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIcon.isNotEmpty()) {
                mUserIconIv.loadUrl(userIcon)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
            Log.e("lchj","wwwww++++登录了  userIcon"+userIcon)
            Log.e("lchj","wwwww++++登录了  mUserNameTv.text "+mUserNameTv.text )
        }else{
            Log.e("lchj","wwwww++++未登录")
            //未登录，显示未登录头像，和文字
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        }
    }
    /**
     * 点击事件
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {
                if(isLogined()){
                    startActivity<UserInfoActivity>()
                }else{
                    startActivity<LoginActivity>()
                }
//                afterLogin {
//                    startActivity<UserInfoActivity>()
//                }
            }
            R.id.mSettingTv -> {
                startActivity<SettingActivity>()
            }

        }
    }

}