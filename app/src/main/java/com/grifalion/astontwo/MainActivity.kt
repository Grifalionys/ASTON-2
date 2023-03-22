package com.grifalion.astontwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.grifalion.astontwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCount = 0

    companion object{
        val KEY_FOR_SECOND_ACTIVITY = "countHello"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showToast()
        countUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("keyInstance", binding.showCount.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.showCount.text = savedInstanceState.getString("keyInstance")
    }

    private fun countUp() = with(binding){
        buttonCount.setOnClickListener {
            mCount++
            if(showCount != null){
                showCount.text = mCount.toString()
            }
        }
    }

    private fun showToast(){
        binding.buttonToast.setOnClickListener {
            Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT).show()
            val intent = Intent(this,SecondActivity::class.java)
            val messageForActivity = binding.showCount.text.toString()
            intent.putExtra(KEY_FOR_SECOND_ACTIVITY,messageForActivity)
            startActivity(intent)
        }
    }
}