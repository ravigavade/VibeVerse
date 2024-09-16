package com.csaim.vibeverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.csaim.vibeverse.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mbtitestbanner.setOnClickListener {
            startActivity(Intent(this,MBTItest::class.java))
        }


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

    }
}