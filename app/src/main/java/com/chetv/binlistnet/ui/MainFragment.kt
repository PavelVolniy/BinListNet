package com.chetv.binlistnet.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.chetv.binlistnet.R
import com.chetv.binlistnet.data.model.base.MainScreenAdapter
import com.chetv.binlistnet.data.model.base.viewBinding
import com.chetv.binlistnet.data.settings.SharedPref
import com.chetv.binlistnet.databinding.MainFragmentBinding
import com.chetv.binlistnet.di.MainScreenComponent
import com.chetv.binlistnet.viewmodel.MainScreenViewModel

class MainFragment : Fragment(R.layout.main_fragment) {
  private val component by lazy { MainScreenComponent.create() }
  private val binding by viewBinding { MainFragmentBinding.bind(it) }
  private val viewModel by viewModels<MainScreenViewModel> { component.viewModelFactory() }
  private val adapter = MainScreenAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      recyclerView.adapter = adapter
//      recyclerView.layoutManager = GridLayoutManager(context, 2)
      viewModel.data.observe(viewLifecycleOwner){
        adapter.items = it
      }

      binding.tvCardNumber.text = context?.let { SharedPref.getCardNumber(it) }
    }
  }
}