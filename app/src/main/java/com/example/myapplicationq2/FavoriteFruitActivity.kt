package com.example.myapplicationq2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FavoriteFruitActivity : AppCompatActivity() {

    private lateinit var selectedFruit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_fruit)

        val fruitSpinner = findViewById<Spinner>(R.id.fruitSpinner)
        val showButton = findViewById<Button>(R.id.showButton)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        val backToMainButton = findViewById<Button>(R.id.backToMainButton)

        // Set up spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.fruits,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fruitSpinner.adapter = adapter
        }

        // Spinner item selected listener
        fruitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedFruit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Button click listener
        showButton.setOnClickListener {
            messageTextView.text = "Your favorite fruit is: $selectedFruit"
        }

        backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("message", "Returned from Favorite Fruit")
            startActivity(intent)
        }
    }
}
