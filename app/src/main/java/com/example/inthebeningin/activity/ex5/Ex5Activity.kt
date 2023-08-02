package com.example.inthebeningin.activity.ex5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.inthebeningin.databinding.ActivityEx5Binding

class Ex5Activity : AppCompatActivity() {

    private val binding by lazy { ActivityEx5Binding.inflate(layoutInflater) }

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

    private fun openWeb() {
        var url = binding.edtWeblink.text.toString()
        if (!url.startsWith(HTTPS)) {
            url = HTTPS + url
        }
        val uri = Uri.parse(url)
        open(uri)
    }

    private fun openMap() {
        val location = binding.edtMapLocation.text.toString()
        val uri = Uri.parse("geo:0,0?q=$location")
        open(uri)
    }

    private fun shareText() {
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

    companion object {
        const val HTTPS = "https://"
    }
}
