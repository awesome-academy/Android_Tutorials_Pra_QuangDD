package com.example.inthebeningin.activity.ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityAfterlifeBinding

class AfterlifeActivity : AppCompatActivity() {
    val binding by lazy { ActivityAfterlifeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val msg = intent.getStringExtra(MainActivity.MAIN_KEY)
        binding.textAfterlife.text = msg
        binding.buttonAfter.setOnClickListener {
            val intent = Intent()
            val rep = binding.edtAfter.text.toString()
            intent.putExtra(EXTRA_REPLY, rep)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "EXTRA_REPLY"
    }
}
