package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class CountryItem(
  val emoji: String,
  val latitude: Int,
  val longitude: Int,
  val name: String
): MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}