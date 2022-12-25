package com.chetv.binlistnet.data.model.base

import com.chetv.binlistnet.ui.MainDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenAdapter:
    AsyncListDifferDelegationAdapter<MainListItem>(BaseDiffUtilItemCallbackMain()){
        init {
          delegatesManager.addDelegate(MainDelegate.mainDelegateVertical())
        }
    }