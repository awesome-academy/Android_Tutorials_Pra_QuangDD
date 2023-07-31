package com.example.inthebeningin.activity.ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.inthebeningin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textMain.text = ""
        binding.buttonMain.setOnClickListener {
            val intent = Intent(this, AfterlifeActivity::class.java)
            val message = binding.edtMain.text.toString()
            intent.putExtra(MAIN_KEY, message)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                binding.textMain.text = data.getStringExtra(AfterlifeActivity.EXTRA_REPLY).toString()
            }
            data?.let {
                binding.textMain.text = it.getStringExtra(AfterlifeActivity.EXTRA_REPLY).toString()
            }

        }
    }

    companion object {
        const val MAIN_KEY = "MAIN_KEY"
        const val REQUEST_CODE = 1
    }


}
