package com.chetv.binlistnet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chetv.binlistnet.R
import com.chetv.binlistnet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    if (savedInstanceState == null){
      supportFragmentManager.beginTransaction()
        .add(R.id.container, StartDialogFragment())
        .commitAllowingStateLoss()
    }
  }
}