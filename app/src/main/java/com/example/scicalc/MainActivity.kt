package com.example.scicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnNavSciCalc).setOnClickListener {
            startActivity(Intent(this, SciCalcActivity::class.java))
        }

        findViewById<Button>(R.id.btnNavCampusHelper).setOnClickListener {
            startActivity(Intent(this, CampusInfoActivity::class.java))
        }
        findViewById<Button>(R.id.btnNavPeakJojo).setOnClickListener {
            startActivity(Intent(this, PeakJOJO::class.java))
        }
    }
}
