package com.fake.icetask1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = FirebaseAuth.getInstance()

        val userEmailTextView = findViewById<TextView>(R.id.userEmail)
        val logoutButton = findViewById<Button>(R.id.logout)

        // Display the logged-in user's email
        val currentUser = auth.currentUser
        userEmailTextView.text = currentUser?.email ?: "Guest User"

        // Logout function
        logoutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginAndRegistration::class.java))
            finish()
        }
    }
}
