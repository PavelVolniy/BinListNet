package com.chetv.binlistnet.data.settings

import android.content.Context

object SharedPref {
  private val CARD_NAME = "cardName"
  private val TABLE_NAME = "tableName"

  fun saveCardNumber(number: String, context: Context) {
    val sharedPreferences = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    if (number.isNotEmpty()) editor.putString(CARD_NAME, number).apply()
  }

  fun getCardNumber(context: Context): String {
    val sharedPreferences = context.getSharedPreferences(TABLE_NAME, Context.MODE_PRIVATE)
     return sharedPreferences.getString(CARD_NAME, " ").toString()
  }
}