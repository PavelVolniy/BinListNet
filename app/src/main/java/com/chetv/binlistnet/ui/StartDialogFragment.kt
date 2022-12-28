package com.chetv.binlistnet.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.chetv.binlistnet.R
import com.chetv.binlistnet.data.model.base.viewBinding
import com.chetv.binlistnet.data.settings.SharedPref
import com.chetv.binlistnet.databinding.EnterNumberDialogFragmentBinding

class StartDialogFragment: Fragment(R.layout.enter_number_dialog_fragment) {
  private val list = mutableListOf<String>()
  private val binding by viewBinding { EnterNumberDialogFragmentBinding.bind(it) }
  private lateinit var sharedPref: SharedPreferences

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    list.add(context?.let { SharedPref.getCardNumber(it) }.toString())
    val adapterList = context?.let { ArrayAdapter(it, R.layout.search_list_item,list) }
    binding.lvList.adapter = adapterList


    binding.btEnter.setOnClickListener {
      saveCard(binding.etNumberCard.text.toString())
      startFragment()
    }
  }

  private fun saveCard(number: String){
    context?.let { SharedPref.saveCardNumber(number, it) }
  }

  private fun startFragment(){
    (context as FragmentActivity).supportFragmentManager.beginTransaction()
      .replace(R.id.container, MainFragment())
      .commit()
  }
}
