package com.chetv.binlistnet.data.model

import com.chetv.binlistnet.data.model.base.MainListItem

class BankItem(
  val city: String,
  val name: String,
  val phone: String,
  val url: String
): MainListItem {
  override val itemId: Long
    get() = this.hashCode().toLong()
}