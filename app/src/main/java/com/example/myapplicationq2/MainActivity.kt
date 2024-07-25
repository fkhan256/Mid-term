package com.example.myapplicationq2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openCalculatorButton = findViewById<Button>(R.id.openCalculatorButton)
        val openFruitAppButton = findViewById<Button>(R.id.openFruitAppButton)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        // Display message if any
        val message = intent.getStringExtra("message")
        messageTextView.text = message

        openCalculatorButton.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("message", "Navigated from Main Activity")
            startActivity(intent)
        }

        openFruitAppButton.setOnClickListener {
            val intent = Intent(this, FavoriteFruitActivity::class.java)
            intent.putExtra("message", "Navigated from Main Activity")
            startActivity(intent)
        }
    }
}
