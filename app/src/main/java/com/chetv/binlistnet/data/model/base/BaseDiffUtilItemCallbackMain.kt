package com.chetv.binlistnet.data.model.base

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtilItemCallbackMain : DiffUtil.ItemCallback<MainListItem>() {
  override fun areItemsTheSame(
    oldItem: MainListItem,
    newItem: MainListItem
  ): Boolean {
    return oldItem.itemId == newItem.itemId
  }

  override fun areContentsTheSame(
    oldItem: MainListItem,
    newItem: MainListItem
  ): Boolean {
    return oldItem.equals(newItem)
  }

}