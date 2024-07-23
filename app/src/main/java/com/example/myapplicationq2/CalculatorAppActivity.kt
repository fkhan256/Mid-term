package com.example.calculatorapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_app)

        val data = intent.getStringExtra("extraData")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = data
    }
}
