package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csaim.vibeverse.databinding.ActivityRegisterPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Register button click listener
        binding.registerbtn.setOnClickListener {
            val email = binding.mail.text.toString().trim()
            val password = binding.pass.text.toString().trim()

            // Validate user input
            if (email.isEmpty()) {
                binding.mail.error = "Please enter your email"
                binding.mail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.pass.error = "Please enter a password"
                binding.pass.requestFocus()
                return@setOnClickListener
            }

            // Firebase authentication - Create new user
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Registration success
                        Log.d("RegisterPage", "createUserWithEmail:success")
                        val user = auth.currentUser
                        startActivity(Intent(this, LoginPage::class.java))
                        finish() // Optional: Close register page after registration
                    } else {
                        // Registration failure
                        Log.w("RegisterPage", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // Navigate to Login page
        binding.linkToLoginPage.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is already signed in and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, GetStarted::class.java))
            finish() // Close register page if user is already signed in
        }
    }
}
