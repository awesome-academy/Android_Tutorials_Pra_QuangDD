package com.example.inthebeningin.activity.ex8

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityEx8Binding

const val STATE_SCORE_1 = "Team 1 Score"
const val STATE_SCORE_2 = "Team 2 Score"
const val PREFS_NAME = "MyPrefs"

class Ex8Activity : AppCompatActivity() {

    private val binding by lazy { ActivityEx8Binding.inflate(layoutInflater) }
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    private var counter1: Int = 0
    private var counter2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        counter1 = sharedPreferences.getInt(STATE_SCORE_1, 0)
        counter2 = sharedPreferences.getInt(STATE_SCORE_2, 0)

        binding.score1.text = counter1.toString()
        binding.score2.text = counter2.toString()

        binding.decreaseTeam1.setOnClickListener {
            counter1 -= 1
            binding.score1.text = counter1.toString()
            saveScores()
        }
        binding.increaseTeam1.setOnClickListener {
            counter1 += 1
            binding.score1.text = counter1.toString()
            saveScores()
        }
        binding.decreaseTeam2.setOnClickListener {
            counter2 -= 1
            binding.score2.text = counter2.toString()
            saveScores()
        }
        binding.increaseTeam2.setOnClickListener {
            counter2 += 1
            binding.score2.text = counter2.toString()
            saveScores()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu?.findItem(R.id.mode_sw)?.setTitle(R.string.day_mode)
        } else {
            menu?.findItem(R.id.mode_sw)?.setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.mode_sw) {
            val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    private fun saveScores() {
        val editor = sharedPreferences.edit()
        editor.putInt(STATE_SCORE_1, counter1)
        editor.putInt(STATE_SCORE_2, counter2)
        editor.apply()
    }
}
