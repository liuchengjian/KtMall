package lchj.kt.mall.ui.fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.mall.common.*
import com.kotlin.mall.ui.adapter.HomeDiscountAdapter
import com.kotlin.mall.ui.adapter.TopicAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import lchj.kotlin.base.widgets.BannerImageLoader
import lchj.kt.mall.R
import me.crosswall.lib.coverflow.CoverFlow
import me.crosswall.lib.coverflow.core.PageItemClickListener

/**
 * Created by XiMiTwo on 2017/12/28.
 */
class HomeFragment:BaseFragment(), BaseRecyclerViewAdapter.OnItemClickListener<String> {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container,savedInstanceState)
        return inflater.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intBanner()
        initNews()
        initDiscount()
        initTopic()
    }



    private fun intBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()
    }
    /**
      * 初始化公告
    */
    private fun initNews(){
        //公告
        mNewsFlipperView.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场", "新用户立领1000元优惠券"))
    }

    /**
     *初始化折扣
     */
    private fun initDiscount() {
        val manager = LinearLayoutManager(context)
        //把方向改为横向
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager
        val discountAdapter = HomeDiscountAdapter(activity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setOnItemClickListener(this)
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
    }

    /**
     * 折扣商品的点击事件
     */
    override fun onItemClick(item: String, position: Int) {
        Log.e("qqqqqqqq","item:"+ item)
        Log.e("qqqqqqqq","position:"+ position)
    }

    /**
     *  初始化主题
     */
    private fun initTopic() {
        mTopicPager.adapter = TopicAdapter(context, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }

}