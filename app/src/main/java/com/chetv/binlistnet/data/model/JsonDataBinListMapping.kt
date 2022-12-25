package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class JsonDataBinListMapping(
  val list: MainListItem
):MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}