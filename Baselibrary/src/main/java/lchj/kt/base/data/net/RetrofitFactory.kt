package lchj.kotlin.base.data.net

import lchj.kotlin.base.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit工厂，单例
 */
class RetrofitFactory private constructor(){
    /**
     * 单例实现
     */
    companion object {
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val interceptor:Interceptor
    private val retrofit: Retrofit
    //初始化
    init {

        /**
         * 通用拦截器
         */
        interceptor = Interceptor { chain ->
            val request = chain.request()
                    .newBuilder()
//                    .addHeader("Content_Type","application/json")
//                    .addHeader("charset","UTF-8")
                    .addHeader("version","1")
                    .addHeader("app_type","android")
//                    .addHeader("token",AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                    .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ALIYUN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }
    /**
     *  OKHttp创建
     */
    private fun initClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)//
                    .addInterceptor(initLogInterceptor())//日志拦截器
                    .connectTimeout(10,TimeUnit.SECONDS)//
                    .readTimeout(10,TimeUnit.SECONDS)
                    .build()

    }

    /**
     * 日志拦截器
     */
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
    /**
     * 具体服务实例化
     */
    fun <T>create(service:Class<T>):T{
        return retrofit.create(service)
    }

}