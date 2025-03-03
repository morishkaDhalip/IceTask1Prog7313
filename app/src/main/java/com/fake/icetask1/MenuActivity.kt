package com.fake.icetask1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val backButton = findViewById<Button>(R.id.button_back)

        backButton.setOnClickListener {
            showToastNotification() // Show Toast instead of sending a notification
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Function to show a Toast message
    private fun showToastNotification() {
        Toast.makeText(this, "Returning to Calculator (MainActivity)", Toast.LENGTH_SHORT).show()
    }
}
