package com.example.scicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val etStudentName = findViewById<EditText>(R.id.etStudentName)
        val rgYear = findViewById<RadioGroup>(R.id.rgYear)
        val cbHostel = findViewById<CheckBox>(R.id.cbHostel)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val studentName = etStudentName.text.toString()
            val selectedYearId = rgYear.checkedRadioButtonId
            val rbYear = findViewById<RadioButton>(selectedYearId)
            val year = rbYear?.text.toString() ?: "N/A"
            val hostelFacility = if (cbHostel.isChecked) "Yes" else "No"

            val message = "Name: $studentName\nYear: $year\nHostel: $hostelFacility"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            startActivity(Intent(this, CampusInfoDetailsActivity::class.java))
        }
    }
}
