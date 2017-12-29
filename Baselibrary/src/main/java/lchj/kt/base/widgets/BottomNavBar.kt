package lchj.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import lchj.kt.base.R

/**
 * Created by XiMiTwo on 2017/12/14.
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    private val mCartBadge:TextBadgeItem
    private val mMsgBadge:ShapeBadgeItem
    /**
     * 初始化
     */
    init {
        //首页
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press,
                resources.getString(R.string.nav_bar_home))//选中时图标
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)//未选中时图标
                .setActiveColorResource(R.color.common_blue)//选中时字体的颜色
                .setInActiveColorResource(R.color.text_normal)//未选中时字体的颜色
        //分类
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press,
                resources.getString(R.string.nav_bar_category))
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)

        //购物车
        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press,
                resources.getString(R.string.nav_bar_cart))
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        mCartBadge = TextBadgeItem()
        mCartBadge.setText("10")
        cartItem.setBadgeItem(mCartBadge)


        //消息
        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press,
                resources.getString(R.string.nav_bar_msg))
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)

        mMsgBadge = ShapeBadgeItem()
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)//圆形
        msgItem.setBadgeItem( mMsgBadge)

        //我的
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press,
                resources.getString(R.string.nav_bar_user))
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        //设置底部导航模式及样式
        setMode(BottomNavigationBar.MODE_FIXED)//模式
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)//背景颜色
        //添加Tab
        addItem(homeItem)
                .addItem(categoryItem)
                .addItem(cartItem)
                .addItem(msgItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)//默认选择第一个
                .initialise()//初始化

    }

    /**
     * 检查购物车Tab是否显示标签
     */
    fun checkCartBadge(count:Int){
        if (count == 0){
            mCartBadge.hide()
        }else{
            mCartBadge.show()
            mCartBadge.setText("$count")
        }
    }

    /**
     * 检查消息Tab是否显示标签
     */
    fun checkMsgBadge(isVisiable:Boolean){
        if (isVisiable){
            mMsgBadge.show()
        }else {
            mMsgBadge.hide()
        }
    }
}