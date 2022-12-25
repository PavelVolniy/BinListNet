package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class CardNumberItem(
  val length: Int,
  val luhn: Boolean
):MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}