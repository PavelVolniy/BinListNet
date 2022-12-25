package com.chetv.binlistnet.di

import androidx.lifecycle.ViewModel
import com.chetv.binlistnet.BuildConfig
import com.chetv.binlistnet.Di
import com.chetv.binlistnet.data.api.BinListApi
import com.chetv.binlistnet.viewmodel.MainScreenViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Component(modules = [NetWorkModule::class, MainViewModel::class])
@Singleton
interface MainScreenComponent {
  fun viewModelFactory(): ViewModelFactory
  fun api(): BinListApi

  @Component.Builder
  interface Builder{
    @BindsInstance
    fun api(api: BinListApi): Builder
    fun build(): MainScreenComponent
  }

  companion object{
    fun create() = with(Di.appComponent){

    }
  }
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

@Module
abstract class MainViewModel{
  @Binds
  @IntoMap
  @ViewModelKey(MainScreenViewModel::class)
  abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}
