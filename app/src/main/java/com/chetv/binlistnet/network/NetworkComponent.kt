package com.chetv.binlistnet.network

import com.chetv.binlistnet.BuildConfig
import com.chetv.binlistnet.data.api.BinListApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [NetWorkModule::class])
@Singleton
interface NetworkComponent {
  fun api(): BinListApi
}

@Module
abstract class NetWorkModule{

  companion object{
    private const val BASE_URL = "https://lookup.binlist.net"

    @Provides
    @Singleton
    fun provideApi(): BinListApi = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(
        OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
          })
          .build())
      .build()
      .create(BinListApi::class.java)
  }
}
