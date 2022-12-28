package com.chetv.binlistnet

import com.chetv.binlistnet.di.AppComponent
import com.chetv.binlistnet.network.NetworkComponent

object Di {
  lateinit var appComponent: AppComponent
  internal set

  lateinit var networkComponent: NetworkComponent
  internal set
}