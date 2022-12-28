package com.chetv.binlistnet.di

import androidx.lifecycle.ViewModel
import com.chetv.binlistnet.Di
import com.chetv.binlistnet.data.api.BinListApi
import com.chetv.binlistnet.util.ResourceProvider
import com.chetv.binlistnet.viewmodel.MainScreenViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap


@Component(modules = [MainScreenModel::class])
interface MainScreenComponent {

  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder{
    @BindsInstance
    fun resource(resourceProvider: ResourceProvider): Builder
    @BindsInstance
    fun api(api: BinListApi): Builder
    fun build(): MainScreenComponent
  }

  companion object{
    fun create() = with(Di.appComponent){
      DaggerMainScreenComponent.builder()
        .resource(resources())
        .api(Di.networkComponent.api())
        .build()
    }
  }
}


@Module
abstract class MainScreenModel{
  @Binds
  @IntoMap
  @ViewModelKey(MainScreenViewModel::class)
  abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}
