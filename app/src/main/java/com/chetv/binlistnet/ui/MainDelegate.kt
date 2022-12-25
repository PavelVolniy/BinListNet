package com.chetv.binlistnet.ui

import androidx.recyclerview.widget.GridLayoutManager
import com.chetv.binlistnet.data.model.*
import com.chetv.binlistnet.data.model.base.MainListItem
import com.chetv.binlistnet.databinding.*
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainDelegate {

  fun mainDelegateVertical() =
    adapterDelegateViewBinding<JsonDataBinListMapping, MainListItem, MainFragmentBinding>(
      { inflater, container ->
        MainFragmentBinding.inflate(inflater, container, false)
          .apply {
            recyclerView.adapter = ListDelegationAdapter(
              countryItem(),
              cardNumberItem(),
              schemaTypeItem(),
              brandPrepaid(),
              bankItem()
            )
          }
      }
    ) {
      //need replace data
      binding.tvCardNumber.text = TODO()
      binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
    }

  private fun countryItem() =
    adapterDelegateViewBinding<CountryItem, MainListItem, CountryItemBinding>({ inflater, container ->
      CountryItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvSymbol.text = item.emoji
        binding.tvLongitude.text = item.longitude.toString()
        binding.tvLotitude.text = item.longitude.toString()
        binding.tvNameCountry.text = item.name
      }
    }

  private fun cardNumberItem() =
    adapterDelegateViewBinding<CardNumberItem, MainListItem, CardNumberItemBinding>({ inflater, container ->
      CardNumberItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvLength.text = item.length.toString()
        binding.rbYes.isChecked = item.luhn
        binding.rbNo.isChecked = !item.luhn
      }
    }

  private fun schemaTypeItem() =
    adapterDelegateViewBinding<SchemaTypeItem, MainListItem, SchemaTypeItemBinding>({ inflater, container ->
      SchemaTypeItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvScheme.text = item.scheme
        binding.tvType.text = item.type
      }
    }

  private fun brandPrepaid() =
    adapterDelegateViewBinding<BrandPrepaidItem, MainListItem, BrandPrepaidItemBinding>({ inflater, container ->
      BrandPrepaidItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvBrand.text = item.brand
        binding.rbYes.isChecked = item.prepaid
        binding.rbNo.isChecked = !item.prepaid
      }
    }

  private fun bankItem() =
    adapterDelegateViewBinding<BankItem, MainListItem, BankItemBinding>({ inflater, container ->
      BankItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvNameBank.text = "${item.name}, ${item.city}"
        binding.tvLinkBank.text = item.url
        binding.tvPhoneBank.text = item.phone
      }
    }
}