package com.sahan.universitiesinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sahan.universitiesinfo.R
import com.sahan.universitiesinfo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }


}