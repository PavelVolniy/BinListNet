package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class SchemaTypeItem(
  val scheme: String,
  val type: String
): MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}