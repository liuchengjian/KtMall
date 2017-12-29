package lchj.kotlin.base.widgets

import android.content.Context
import android.widget.ImageView
import com.kotlin.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * Created by XiMiTwo on 2017/12/14.
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadUrlImage(context, path.toString(), imageView)
    }
}