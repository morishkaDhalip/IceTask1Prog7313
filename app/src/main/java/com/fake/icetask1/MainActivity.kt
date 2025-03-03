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
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // Function to get numbers safely
        fun getNumbers(): Pair<Int, Int> {
            val num1 = num1EditText.text.toString().toIntOrNull() ?: 0
            val num2 = num2EditText.text.toString().toIntOrNull() ?: 0
            return Pair(num1, num2)
        }

        // Addition
        addButton.setOnClickListener {
            val (num1, num2) = getNumbers()
            resultTextView.text = "Answer: ${num1 + num2}"
        }

        // Subtraction
        subtractButton.setOnClickListener {
            val (num1, num2) = getNumbers()
            resultTextView.text = "Answer: ${num1 - num2}"
        }

        // Multiplication
        multiplyButton.setOnClickListener {
            val (num1, num2) = getNumbers()
            resultTextView.text = "Answer: ${num1 * num2}"
        }

        // Division
        divideButton.setOnClickListener {
            val (num1, num2) = getNumbers()
            if (num2 != 0) {
                resultTextView.text = "Answer: ${num1 / num2}"
            } else {
                resultTextView.text = "Cannot divide by zero"
            }
        }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
