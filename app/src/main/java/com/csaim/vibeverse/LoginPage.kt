package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.csaim.vibeverse.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Login button click listener
        binding.loginbtn.setOnClickListener {
            val mailId = binding.mail.text.toString().trim()
            val passId = binding.pass.text.toString().trim()

            // Check if email and password fields are not empty
            if (mailId.isEmpty()) {
                binding.mail.error = "Please enter your email"
                binding.mail.requestFocus()
                return@setOnClickListener
            }

            if (passId.isEmpty()) {
                binding.pass.error = "Please enter your password"
                binding.pass.requestFocus()
                return@setOnClickListener
            }

            // Firebase authentication
            auth.signInWithEmailAndPassword(mailId, passId)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        Log.d("LoginPage", "signInWithEmail:success")
                        val user = auth.currentUser
                        startActivity(Intent(this, GetStarted::class.java))
                        finish() // Optional: Close login page after successful login
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("LoginPage", "signInWithEmail:failure", task.exception)
                        Toast.makeText(this, "Authentication failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // Navigate to Register page
        binding.linkToRegisterPage.setOnClickListener {
            startActivity(Intent(this, RegisterPage::class.java))
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is already signed in and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Optional: Close login page if user is already logged in
        }
    }
}
