package com.example.myapplicationq2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val num1 = etNumber1.text.toString().toDouble()
            val num2 = etNumber2.text.toString().toDouble()
            val operation = spinner.selectedItem.toString()

            val result = when (operation) {
                "Addition" -> num1 + num2
                "Subtraction" -> num1 - num2
                "Multiplication" -> num1 * num2
                "Division" -> num1 / num2
                else -> 0.0
            }

            tvResult.text = "Result: $result"
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Do something when an item is selected
            }
        }
    }
}
