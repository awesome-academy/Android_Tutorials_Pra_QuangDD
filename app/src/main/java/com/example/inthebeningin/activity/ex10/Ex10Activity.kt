package com.example.inthebeningin.activity.ex10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityEx10Binding
import com.google.android.material.tabs.TabLayout

class Ex10Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivityEx10Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.tabLayout.apply {
            addTab(this.newTab().setText(R.string.tab_1))
            addTab(this.newTab().setText(R.string.tab_2))
            addTab(this.newTab().setText(R.string.tab_3))
            tabGravity = TabLayout.GRAVITY_FILL
        }
        val adapter = PagerAdapter(supportFragmentManager,binding.tabLayout.tabCount)
        binding.pager.adapter = adapter
        binding.pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener (object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.pager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}
