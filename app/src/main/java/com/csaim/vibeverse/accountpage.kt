package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityAccountpageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class accountpage : AppCompatActivity() {

    private lateinit var binding:ActivityAccountpageBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAccountpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        // Get the current user's email
        val currentUser = auth.currentUser
        val email = currentUser?.email ?: "Unknown User"

        binding.user.text= email


        binding.logoutbtn.setOnClickListener {
            try {
                Firebase.auth.signOut()
                if (Firebase.auth.currentUser == null) {
                    startActivity(Intent(this, LoginPage::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("SignOutError", "Error signing out: ${e.message}")
                Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.home.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(0, 0)
        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        // Close all activities and exit the app
        finishAffinity()
    }
}