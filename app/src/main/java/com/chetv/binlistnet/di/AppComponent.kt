package com.chetv.binlistnet.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent {
  @Component.Builder
  abstract class Builder {
    @BindsInstance
    abstract fun appContext(context: Context): Builder
    abstract fun build(): AppComponent
  }

}




