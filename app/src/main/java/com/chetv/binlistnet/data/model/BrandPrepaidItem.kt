package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class BrandPrepaidItem(
  val brand: String,
  val prepaid: Boolean
): MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}