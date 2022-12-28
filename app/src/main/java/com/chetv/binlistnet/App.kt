package com.chetv.binlistnet

import android.app.Application
import com.chetv.binlistnet.di.DaggerAppComponent
import com.chetv.binlistnet.network.DaggerNetworkComponent

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {
    Di.appComponent = DaggerAppComponent.builder()
      .appContext(this)
      .build()

    Di.networkComponent = DaggerNetworkComponent.create()
  }
}