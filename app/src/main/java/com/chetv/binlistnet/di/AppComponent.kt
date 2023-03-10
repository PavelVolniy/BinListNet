package com.chetv.binlistnet.di

import android.content.Context
import com.chetv.binlistnet.util.AndroidResourceProviderImpl
import com.chetv.binlistnet.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
  fun resources(): ResourceProvider

  @Component.Builder
  abstract class Builder {
    @BindsInstance
    abstract fun appContext(context: Context): Builder
    abstract fun build(): AppComponent
  }

}

@Module
abstract class AppModule{
  @Binds
  @Singleton
  abstract fun bindResourceProvider(provider: AndroidResourceProviderImpl): ResourceProvider
}




