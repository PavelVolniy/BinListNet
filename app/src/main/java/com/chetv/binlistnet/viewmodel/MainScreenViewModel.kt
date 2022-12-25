package com.chetv.binlistnet.viewmodel

import com.chetv.binlistnet.data.api.BinListApi
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val api: BinListApi
): BaseViewModel() {
}