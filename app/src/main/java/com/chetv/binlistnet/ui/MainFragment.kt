package com.chetv.binlistnet.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.chetv.binlistnet.R
import com.chetv.binlistnet.data.model.base.MainScreenAdapter
import com.chetv.binlistnet.data.model.base.viewBinding
import com.chetv.binlistnet.databinding.MainFragmentBinding

class MainFragment: Fragment(R.layout.main_fragment) {
  private val adapter = MainScreenAdapter()
  private val binding by viewBinding { MainFragmentBinding.bind(it) }
//  private val component by lazy { AppComponent.create() }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding){
      recyclerView.adapter = adapter
      binding.tvCardNumber
    }
  }
}