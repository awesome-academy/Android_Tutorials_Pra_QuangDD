package com.example.inthebeningin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textMain.text = ""
        binding.buttonMain.setOnClickListener(this::clk)
    }

    fun clk(v:View){
        val intent = Intent(this, AfterlifeActivity::class.java)
        val message = binding.edtMain.text.toString()
        Log.d("ben", "clk: $message")
        intent.putExtra("key1", message)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    binding.textMain.text = data.getStringExtra(EXTRA_REPLY).toString()
                }
                data?.let {
                    binding.textMain.text = it.getStringExtra(EXTRA_REPLY).toString()
                }
            }
        }
    }


}