package lchj.kt.mall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.provider.common.isLogined
import com.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*
import lchj.kotlin.base.ext.enable
import lchj.kotlin.base.ext.onClick
import lchj.kotlin.base.ui.activity.BaseActivity
import lchj.kt.mall.R
import lchj.kt.user.utils.file.DataCleanManager
import org.jetbrains.anko.toast

class SettingActivity : BaseActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        //判断是否登录，然后是确定退出按钮是否能点击
        mLogoutBtn.isEnabled = isLogined()
        TvNerCunSize.text = DataCleanManager.getTotalCacheSize(this)
        initView()

    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mUserClearNercun.onClick(this)
        mUserProtocolTv.onClick(this)
        mFeedBackTv.onClick(this)
        mAboutTv.onClick(this)
        mLogoutBtn.onClick(this)
    }

    /**
     * 点击事件
     */
    override fun onClick(view: View) {
        when(view.id){
            R.id.mUserClearNercun->{
                DataCleanManager.cleanInternalCache(this)
                DataCleanManager.cleanExternalCache(this)
                DataCleanManager.cleanFiles(this)
                TvNerCunSize.text = DataCleanManager.getTotalCacheSize(this)

                toast("清除成功")
            }
            R.id.mUserProtocolTv ->{
                toast("用户协议")
            }
            R.id.mFeedBackTv ->{
                toast("反馈意见")
            }
            R.id. mAboutTv ->{
                toast("关于")
            }
             //退出登录，清空本地用户数据
            R.id.mLogoutBtn ->{
                    UserPrefsUtils.putUserInfo(null)
                    UserPrefsUtils.putUserToken(null)
                    finish()
            }

        }
    }

}
