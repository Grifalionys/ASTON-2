package com.grifalion.astontwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grifalion.astontwo.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val showCount = intent.getStringExtra(MainActivity.KEY_FOR_SECOND_ACTIVITY)
        binding.tvCount.text = showCount.toString()
    }
}