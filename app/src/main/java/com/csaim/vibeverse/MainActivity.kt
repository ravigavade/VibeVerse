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




        binding.account.setOnClickListener{

            val intent=(Intent(this,accountpage::class.java))
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