package com.idea_festival.golaroid_android.module
import com.idea_festival.data.remote.network.ImageAPI
import com.idea_festival.data.remote.network.PostAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cookieJar(CookieJar.NO_COOKIES)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://golaroid.store/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideImageService(retrofit: Retrofit): ImageAPI {
        return retrofit.create(ImageAPI::class.java)
    }

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostAPI {
        return retrofit.create(PostAPI::class.java)
    }
}