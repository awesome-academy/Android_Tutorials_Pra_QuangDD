package com.example.inthebeningin.activity.ex9

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.inthebeningin.R
import com.example.inthebeningin.databinding.ActivityEx9Binding
import java.util.Calendar

class Ex9Activity : AppCompatActivity() {

    private val binding by lazy { ActivityEx9Binding.inflate(layoutInflater) }
    private val calendar by lazy { Calendar.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alertBtn.setOnClickListener {
            onClickShowAlert()
        }
        binding.datePickerBtn.setOnClickListener {
            showDatePicker()
        }
    }

    private fun onClickShowAlert() {
        val myAlertBuilder = AlertDialog.Builder(this)
        myAlertBuilder.setTitle(getString(R.string.alert_title))
            .setMessage(getString(R.string.dialog_message))
            .setPositiveButton(
                getString(R.string.ok)
            ) { _, _ ->
                Toast.makeText(applicationContext, getString(R.string.pressed_ok), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(
                getString(R.string.cancel)
            ) { _, _ ->
                Toast.makeText(
                    applicationContext,
                    getString(R.string.pressed_cancel),
                    Toast.LENGTH_SHORT
                ).show()
            }
            .show()
    }
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                showToast(getString(R.string.date_message, day, month, year))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
