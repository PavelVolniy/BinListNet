package com.chetv.binlistnet.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.binlistnet.R
import com.chetv.binlistnet.data.api.BinListApi
import com.chetv.binlistnet.data.model.*
import com.chetv.binlistnet.data.model.base.MainListItem
import com.chetv.binlistnet.util.ResourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val resources: ResourceProvider,
  private val api: BinListApi
) : BaseViewModel() {
  private val _data = MutableLiveData<List<MainListItem>>()
  val data: MutableLiveData<List<MainListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val items = getDataItems()
      _data.postValue(items)
    }
  }


  private suspend fun getDataItems(): List<MainListItem> {
    resources.string(R.string.app_name)
    val data = api.getDataFromServer()
    return listOf(
      SchemaTypeItem(data.scheme, data.type),
      BrandPrepaidItem(data.brand, data.prepaid),
      CardNumberItem(data.number.length, data.number.luhn),
      CountryItem(
        data.country.emoji,
        data.country.latitude,
        data.country.longitude,
        data.country.name
      ),
      BankItem(data.bank.city, data.bank.name, data.bank.phone, data.bank.url)

    )
  }

  private fun getFakeData(): List<MainListItem>{
    return listOf(
      SchemaTypeItem("Visa", "Debit"),
      BankItem("Jyske Bank", "some country", "+48666656", "www.someUrl@.com"),
      BrandPrepaidItem("VIsa", false),
      CardNumberItem(12, true),
      CountryItem("()", 121212, 454545, "Denmark")
    )
  }
}