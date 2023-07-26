package com.example.inthebeningin.activity.ex5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inthebeningin.databinding.ActivityEx5Binding

class Ex5Activity : AppCompatActivity() {

    val binding by lazy { ActivityEx5Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnOpenWeb.setOnClickListener {
            openWeb()
        }
        binding.btnOpenMap.setOnClickListener {
            openMap()
        }
        binding.btnShareText.setOnClickListener {
            shareText()
        }
    }

    fun openWeb() {
        val url = binding.edtWeblink.text.toString()
        val uri = Uri.parse(url)
        open(uri)
    }

    fun openMap() {
        val location = binding.edtMapLocation.text.toString()
        val uri = Uri.parse("geo:0,0?q=$location")
        open(uri)
    }

    fun shareText() {
        val text = binding.edtText.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.setType("text/plain")

        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun open(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

    }
}
