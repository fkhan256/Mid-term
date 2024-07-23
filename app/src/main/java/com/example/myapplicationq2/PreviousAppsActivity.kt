package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PreviousAppsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_apps)

        val btnOpenApp1 = findViewById<Button>(R.id.btnOpenApp1)
        val btnOpenApp2 = findViewById<Button>(R.id.btnOpenApp2)

        btnOpenApp1.setOnClickListener {
            val intent = Intent(this, CalculatorAppActivity::class.java)
            intent.putExtra("extraData", "Data from PreviousAppsActivity")
            startActivity(intent)
        }

        btnOpenApp2.setOnClickListener {
            val intent = Intent(this, SpinnerAppActivity::class.java)
            intent.putExtra("extraData", "Data from PreviousAppsActivity")
            startActivity(intent)
        }
    }
}
