package com.example.inthebeningin.activity.ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityAfterlifeBinding
val EXTRA_REPLY = "a"
class AfterlifeActivity : AppCompatActivity() {
    val binding by lazy { ActivityAfterlifeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val msg = intent.getStringExtra("key1")
        binding.textAfterlife.text = msg
        binding.buttonAfter.setOnClickListener {
            clk()
        }
    }
    fun clk() {
        val intent = Intent()
        val rep = binding.edtAfter.text.toString()
        intent.putExtra(EXTRA_REPLY, rep)
        setResult(RESULT_OK, intent)
        finish()

        // test 1
        // test 2
    }
}