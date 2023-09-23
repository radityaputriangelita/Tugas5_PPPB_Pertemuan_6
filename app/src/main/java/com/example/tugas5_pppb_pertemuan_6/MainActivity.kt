package com.example.tugas5_pppb_pertemuan_6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.example.tugas5_pppb_pertemuan_6.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = resources.getStringArray(R.array.country)
        val ClassSeat = resources.getStringArray(R.array.ClassSeat)

        with(binding){

            val countryAdaptor = ArrayAdapter(
                this@MainActivity,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,country
            )
            countryAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinFrom.adapter = countryAdaptor
            countryAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinTo.adapter = countryAdaptor

            buttonTgl.setOnClickListener{
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener{
                        _, year, monthOfYear, dayOfMonth -> mdy.setText("" + dayOfMonth + "/" + (monthOfYear+1) + "/" + year)
                }, year, month,day)
                dpd.show()
            }
            buttonTime.setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@MainActivity,
                    TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                        time.text = String.format("%02d:%02d", selectedHour, selectedMinute)
                    },
                    hour,
                    minute,
                    false
                )
                timePickerDialog.show()
            }
            val ClassSeatAdaptor = ArrayAdapter(
                this@MainActivity,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ClassSeat
            )
            ClassSeatAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinSeat.adapter = ClassSeatAdaptor

            btnOrder.setOnClickListener{
                Toast.makeText(this@MainActivity, "Tiket " + mdy.text +" "+ time.text + " Berhasil Dipesan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

