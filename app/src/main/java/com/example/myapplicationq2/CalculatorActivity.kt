package com.example.myapplicationq2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val number1EditText = findViewById<EditText>(R.id.number1)
        val number2EditText = findViewById<EditText>(R.id.number2)
        val operationSpinner = findViewById<Spinner>(R.id.operationSpinner)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val backToMainButton = findViewById<Button>(R.id.backToMainButton)

        // Set up spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.operations,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            operationSpinner.adapter = adapter
        }

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDoubleOrNull()
            val number2 = number2EditText.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (number1 != null && number2 != null) {
                val result = when (operation) {
                    "Addition" -> number1 + number2
                    "Subtraction" -> number1 - number2
                    "Multiplication" -> number1 * number2
                    "Division" -> {
                        if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
                    }
                    else -> "Invalid operation"
                }
                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
        }

        backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("message", "Returned from Calculator")
            startActivity(intent)
        }
    }
}
