package com.chetv.binlistnet.ui

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.chetv.binlistnet.data.model.*
import com.chetv.binlistnet.data.model.base.MainListItem
import com.chetv.binlistnet.databinding.*
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainDelegate {

  fun countryItem() =
    adapterDelegateViewBinding<CountryItem, MainListItem, CountryItemBinding>(
      { inflater, container ->
        CountryItemBinding.inflate(inflater, container, false)
      }) {
      bind {
        binding.tvSymbol.text = item.emoji
        binding.tvLongitude.text = item.longitude.toString()
        binding.tvLotitude.text = item.longitude.toString()
        binding.tvNameCountry.text = item.name
      }
    }

  fun cardNumberItem() =
    adapterDelegateViewBinding<CardNumberItem, MainListItem, CardNumberItemBinding>(
      { inflater, container ->
        CardNumberItemBinding.inflate(inflater, container, false)
      }) {
      bind {
        binding.tvLength.text = item.length.toString()
        binding.rbYes.isChecked = item.luhn
        binding.rbNo.isChecked = !item.luhn
      }
    }

  fun schemaTypeItem() =
    adapterDelegateViewBinding<SchemaTypeItem, MainListItem, SchemaTypeItemBinding>(
      { inflater, container ->
        SchemaTypeItemBinding.inflate(inflater, container, false)
      }) {
      bind {
        binding.tvScheme.text = item.scheme
        binding.tvType.text = item.type
      }
    }

  fun brandPrepaid() =
    adapterDelegateViewBinding<BrandPrepaidItem, MainListItem, BrandPrepaidItemBinding>(
      { inflater, container ->
        BrandPrepaidItemBinding.inflate(inflater, container, false)
      }) {
      bind {
        binding.tvBrand.text = item.brand
        binding.rbYes.isChecked = item.prepaid
        binding.rbNo.isChecked = !item.prepaid
      }
    }

  fun bankItem() =
    adapterDelegateViewBinding<BankItem, MainListItem, BankItemBinding>({ inflater, container ->
      BankItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvNameBank.text = "${item.name}, ${item.city}"
        binding.tvLinkBank.text = item.url
        binding.tvLinkBank.setOnClickListener {
          val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
          Intent.FLAG_ACTIVITY_NEW_TASK
          context.startActivity(Intent.createChooser(intent, "no app"))
        }
        binding.tvPhoneBank.text = item.phone

        binding.tvPhoneBank.setOnClickListener {
          val intent = Intent(Intent.EXTRA_PHONE_NUMBER, Uri.parse(item.phone))
          context.startActivity(Intent.createChooser(intent, "text"))
        }
      }
    }
}