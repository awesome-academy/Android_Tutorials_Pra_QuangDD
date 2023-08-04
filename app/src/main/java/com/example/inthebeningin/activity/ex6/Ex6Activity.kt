package com.example.inthebeningin.activity.ex6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityEx6Binding


class Ex6Activity : AppCompatActivity() {

    val binding by lazy {ActivityEx6Binding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonOpen.run {
            setOnClickListener {
                val fragment = supportFragmentManager
                    .findFragmentById(binding.fragment.id) as? SimpleFragment
                text = if (fragment == null) {
                    supportFragmentManager
                        .beginTransaction()
                        .add(binding.fragment.id, SimpleFragment.newInstance())
                        .commit()
                    getString(R.string.close)
                } else {
                    supportFragmentManager
                        .beginTransaction()
                        .remove(fragment).commit()
                    getString(R.string.open)

                }
            }

        }
    }


}
