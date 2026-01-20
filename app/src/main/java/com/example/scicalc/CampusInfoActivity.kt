package com.example.scicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class CampusInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campus_info)
        Log.d("Lifecycle", "onCreate invoked")

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = showGreeting()

        val btnGoToInfo = findViewById<Button>(R.id.btnGoToInfo)
        btnGoToInfo.setOnClickListener {
            startActivity(Intent(this, StudentDetailsActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume invoked")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop invoked")
    }

    private fun showGreeting(): String {
        return "Hello Student, Explore Your Campus!"
    }
}
