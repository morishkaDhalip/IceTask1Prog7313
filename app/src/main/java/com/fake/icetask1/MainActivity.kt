package com.fake.icetask1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find views by ID
        val num1EditText = findViewById<EditText>(R.id.num1EditText)
        val num2EditText = findViewById<EditText>(R.id.num2EditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // Set click listener on button
        addButton.setOnClickListener {
            // Get numbers from EditText fields
            val num1 = num1EditText.text.toString().toIntOrNull() ?: 0
            val num2 = num2EditText.text.toString().toIntOrNull() ?: 0

            // Perform addition
            val sum = num1 + num2

            // Display result
            resultTextView.text = "Answer: $sum"

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}