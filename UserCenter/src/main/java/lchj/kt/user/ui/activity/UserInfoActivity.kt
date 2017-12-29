package lchj.kt.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.activity_user_info.*
import lchj.kotlin.base.ext.onClick
import lchj.kt.base.ui.activity.BaseTakePhotoActivity
import lchj.kt.user.R
import lchj.kt.user.data.protocol.UserInfo
import lchj.kt.user.presenter.RegisterPresenter
import lchj.kt.user.presenter.UserInfoPresenter
import lchj.kt.user.presenter.view.UserInfoView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class UserInfoActivity : BaseTakePhotoActivity<UserInfoPresenter>(),UserInfoView {
    private var mLocalFileUrl:String? = null
    private var mRemoteFileUrl:String? = null

    private var mUserIcon:String? = null
    private var mUserIconUri:String? = null
    private var mUserName:String? = null
    private var mUserMobile:String? = null
    private var mUserGender:String? = null
    private var mUserSign:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        initView()
        initData()
    }
    /**
     *  初始化视图
     */
    private fun initView() {
        mPresenter = UserInfoPresenter()
        mPresenter.mView = this

        mUserIconView.onClick{
            //弹出选择弹框
            showAlertView()
        }
        mHeaderBar.getRightView().onClick {
//            mPresenter.editUser(mRemoteFileUrl!!,
//                    mUserNameEt.text?.toString()?:"",
//                    if(mGenderMaleRb.isChecked) "0" else "1",
//                    mUserSignEt.text?.toString()?:""
//            )
            //测试代码
            mUserName = mUserNameEt.text.toString()
            mUserSign = mUserSignEt.text.toString()
            AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON,mLocalFileUrl!!)
            AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, mUserName!!)
            AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, mUserSign!!)
            finish()
        }

        mUserMobileTv.text
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        mUserIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
        mUserName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        mUserMobile = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_MOBILE)
        mUserGender = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_GENDER)
        mUserSign = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_SIGN)
        mLocalFileUrl = mUserIcon

        if (mUserIcon != ""){

            GlideUtils.loadImage(this,mUserIcon!!,mUserIconIv)
//            GlideUtils.loadUrlImage(this,mUserIcon!!,mUserIconIv)
        }
        mUserNameEt.setText(mUserName)
        mUserMobileTv.text = mUserMobile
//        mUserMobileTv.text = intent.getStringExtra("phone")

        if (mUserGender == "0") {
            mGenderMaleRb.isChecked = true
        }
        else {
            mGenderFemaleRb.isChecked = true
        }
        mUserSignEt.setText(mUserSign)
    }
    /**
     * 获取图片，成功回调
     */
    override fun takeSuccess(result: TResult?) {
        mLocalFileUrl = result?.image?.originalPath
        Log.e("tttttt","wwww:"+ mLocalFileUrl)

        //加载本地图片,测试
        GlideUtils.loadImage(this, mLocalFileUrl!!,mUserIconIv)
    }

    /**
     * 获取上传凭证回调
     */
    override fun onGetUploadTokenResult(result: String) {
        TODO("not implemented")
    }
    /**
     *  编辑用户资料回调
     */
    override fun onEditUserResult(result: UserInfo) {
        toast("修改成功")
        TODO("not implemented")
    }
}
